package com.fangyou;

import com.fangyou.filter.AccessTokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class Getway5555_StartSpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(Getway5555_StartSpringCloudApplication.class);
    }

    @Bean
    public AccessTokenFilter accessFilter(){
        return new AccessTokenFilter();
    }
}
