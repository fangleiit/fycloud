package com.fangyou;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Eureka1111_StartSpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(Eureka1111_StartSpringCloudApplication.class);
    }
}
