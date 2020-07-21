package com.fangyou.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.spi.http.HttpHandler;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;

@Configuration
public class RestConfig {
    @Bean
    public HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        String auto = "admin:admin";
        byte[] encodeAuto = Base64.getEncoder().encode(auto.getBytes(Charset.forName("US-ASCII")));
        String autoHeader = "Basic " + new String(encodeAuto);
        headers.set("Authorization", autoHeader);
        return headers;
    }



    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
