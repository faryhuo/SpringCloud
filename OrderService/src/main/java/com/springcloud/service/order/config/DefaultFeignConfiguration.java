package com.springcloud.service.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultFeignConfiguration {

    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.FULL;
    }
}
