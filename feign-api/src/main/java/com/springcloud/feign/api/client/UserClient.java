package com.springcloud.feign.api.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userservice")
public interface UserClient {

    @GetMapping("/user/all")
    Object findAll();

    @GetMapping("/user/{id}")
    Object findById(@PathVariable("id") String Id);
}
