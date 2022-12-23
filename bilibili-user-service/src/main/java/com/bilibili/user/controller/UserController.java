package com.bilibili.user.controller;

import com.bilibili.common.model.JsonResponse;
import com.bilibili.common.utils.RSAUtils;
import com.bilibili.user.model.UserModel;
import com.bilibili.user.pojo.User;
import com.bilibili.user.service.UserService;
import com.bilibili.user.utils.UserSupport;
import io.swagger.annotations.ApiImplicitParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    UserSupport userSupport;

    @GetMapping(value = "/rsapubkey")
    public JsonResponse<String> getRSAPublicKey() throws Exception {
        return JsonResponse.ok(RSAUtils.getPublicKeyStr());
    }
    @PostMapping(value = "/user")
    public JsonResponse<Boolean> addUser(@RequestBody UserModel user) throws SQLException {
        return JsonResponse.ok(userService.addUser(user));
    }

    @PostMapping(value = "/user-tokens")
    public JsonResponse<String> login(@RequestBody UserModel user) throws Exception {
        String token=userService.login(user.getPhone(),user.getPassword());
        if(StringUtils.isNotBlank(token)) {
            return JsonResponse.ok(token);
        }else{
            return JsonResponse.fail("Failed to login");
        }
    }

    @GetMapping(value = "/user")
    @ApiImplicitParam(value = "token",name = "token", paramType = "header",dataType="String", required = true)
    public JsonResponse<User> getUserInfo() throws Exception {
        Long userId=userSupport.getCurrentUserId();
        return JsonResponse.ok(userService.getUserById(userId));
    }

    @GetMapping(value = "/user/{userId}")
    public JsonResponse<Boolean> checkUserIfExisting(@PathVariable("userId") Long userId) throws Exception {
        return JsonResponse.ok(userService.getUserById(userId)!=null);
    }

}
