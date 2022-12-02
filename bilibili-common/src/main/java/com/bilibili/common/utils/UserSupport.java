package com.bilibili.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class UserSupport {

    public static Long getCurrentUserId() throws Exception {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String token = requestAttributes.getRequest().getHeader("token");
        return getCurrentUserId(token);
    }

    public static Long getCurrentUserId(String token) throws Exception {
        Long userId= Long.parseLong(TokenUtils.verifyToken(token));
        if(userId<0){
            throw new RuntimeException("");
        }
        return userId;
    }

}
