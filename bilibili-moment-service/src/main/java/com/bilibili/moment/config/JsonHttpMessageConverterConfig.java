package com.bilibili.moment.config;


import com.bilibili.common.config.CommonJsonHttpMessageConverterConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.nio.charset.Charset;

@Configuration
public class JsonHttpMessageConverterConfig {
    @Bean
    @Primary
    public HttpMessageConverters httpMessageConverters(){
        return CommonJsonHttpMessageConverterConfig.getHttpMessageConverters();
    }
}
