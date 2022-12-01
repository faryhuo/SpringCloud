package com.bilibili.common.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.nio.charset.Charset;

public class CommonJsonHttpMessageConverterConfig {

    public static HttpMessageConverters getHttpMessageConverters(){
        MappingJackson2HttpMessageConverter converters= new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper=new ObjectMapper();
        converters.setObjectMapper(objectMapper);
        converters.setPrettyPrint(true);
        converters.setDefaultCharset(Charset.forName("UTF-8"));
        return new HttpMessageConverters(converters);
    }
}
