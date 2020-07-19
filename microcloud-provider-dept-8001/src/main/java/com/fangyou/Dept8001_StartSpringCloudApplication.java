package com.fangyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Dept8001_StartSpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(Dept8001_StartSpringCloudApplication.class);
    }
}
