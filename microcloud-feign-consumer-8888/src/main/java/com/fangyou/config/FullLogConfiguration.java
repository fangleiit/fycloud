package com.fangyou.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FullLogConfiguration {
    @Bean
    Logger.Level feignLoggerLevel(){
        return feign.Logger.Level.FULL;
    }
}

