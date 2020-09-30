package com.fangyou.sysuser.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class ConsumerService {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders headers;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        long start = System.currentTimeMillis();
        String responStr = restTemplate.exchange("http://sysuser8020/sysuser/hellohystrix/", HttpMethod.GET,request,String.class).getBody();
        long end = System.currentTimeMillis();
        System.out.println("Spend time ： " + (end - start));
        return responStr;
    }

    public String helloFallback(){
        return "error";
    }
}
