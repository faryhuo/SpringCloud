package com.springcloud.service.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/all")
    public Object getUserList(){
        Map<String,String> object =new HashMap<>();
        object.put("name","user1");
        object.put("age","11");
        return object;
    }

}

