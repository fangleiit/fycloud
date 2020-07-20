package com.fangyou.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class ConsumerService {
    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        long start = System.currentTimeMillis();
        String responStr = restTemplate.getForEntity("http://login8020/sysuser/hellohystrix/",String.class).getBody();
        long end = System.currentTimeMillis();
        System.out.println("Spend time ： " + (end - start));
        return responStr;
    }

    public String helloFallback(){
        return "error";
    }
}
