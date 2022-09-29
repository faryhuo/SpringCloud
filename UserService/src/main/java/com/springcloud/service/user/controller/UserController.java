package com.springcloud.service.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/all")
    public Object getUserList(){
        Map<String,String> object =new HashMap<>();
        object.put("name","user1");
        object.put("age","11");
        System.out.println("Call User");
        return object;
    }

    @GetMapping("/{id}")
    public Object getUserById(@PathVariable("id") String id){
        Map<String,String> object =new HashMap<>();
        object.put("name","user1");
        object.put("age","11");
        object.put("id",id);
        System.out.println("Call User by id");
        return object;
    }
}

