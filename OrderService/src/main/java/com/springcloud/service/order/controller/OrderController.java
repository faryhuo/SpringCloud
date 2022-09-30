package com.springcloud.service.order.controller;

import com.springcloud.feign.api.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserClient client;

    @GetMapping("/all")
    public Object getOrderList(){
        Map<String,Object> object =new HashMap<>();
        object.put("name","user1");
        //String user= restTemplate.getForEntity("http://userservice/user/all",String.class).getBody();
        Object user= client.findById("2");
        object.put("age",user);
        return object;
    }

}

