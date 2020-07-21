package com.fangyou.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRibbonConfiguration {
    public IPing ribbonPing(IClientConfig config){
        return new PingUrl();
    }
}
