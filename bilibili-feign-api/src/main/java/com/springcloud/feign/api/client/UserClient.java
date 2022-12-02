package com.springcloud.feign.api.client;


import com.bilibili.common.model.JsonResponse;
import com.bilibili.user.model.UserModel;
import com.bilibili.user.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("user-service")
public interface UserClient {

    @GetMapping(value = "/rsapubkey")
    JsonResponse<String> getRSAPublicKey() throws Exception;

    @PostMapping(value = "/user")
    JsonResponse<Boolean> addUser(UserModel user);

    @PostMapping(value = "/user-tokens")
    JsonResponse<String> login(UserModel user) throws Exception;

    @GetMapping(value = "/user")
    JsonResponse<User> getUserInfo() throws Exception;

    @GetMapping(value = "/user/{userId}")
    JsonResponse<Boolean> checkUserIfExisting(Long userId);
}
