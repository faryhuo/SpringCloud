package com.bilibili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class Application {

    //com.bilibili.Application entry
    public  static void main(String args[])  {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
    }
}
