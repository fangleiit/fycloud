package com.fangyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class Getway5555_StartSpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(Getway5555_StartSpringCloudApplication.class);
    }
}
