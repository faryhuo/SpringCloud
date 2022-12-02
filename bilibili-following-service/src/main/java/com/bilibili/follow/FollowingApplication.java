package com.bilibili.follow;

import com.springcloud.feign.api.client.UserClient;
import com.springcloud.feign.api.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
@MapperScan("com.bilibili.follow.dao")
@EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class,
        clients = {UserClient.class})
public class FollowingApplication {

    //Application entry
    public  static void main(String args[])  {
        ApplicationContext applicationContext = SpringApplication.run(FollowingApplication.class, args);
    }


}
