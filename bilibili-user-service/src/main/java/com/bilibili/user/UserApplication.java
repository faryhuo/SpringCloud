package com.bilibili.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
@MapperScan("com.bilibili.user.dao")
public class UserApplication {

    //Application entry
    public  static void main(String args[])  {
        ApplicationContext applicationContext = SpringApplication.run(UserApplication.class, args);
    }


}
