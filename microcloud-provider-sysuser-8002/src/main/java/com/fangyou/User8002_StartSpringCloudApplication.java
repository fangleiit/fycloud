package com.fangyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class User8002_StartSpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(User8002_StartSpringCloudApplication.class);
    }
}
