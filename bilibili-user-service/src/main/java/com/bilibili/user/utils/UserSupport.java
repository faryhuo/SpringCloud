package com.bilibili.user.utils;

import com.bilibili.common.utils.TokenUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UserSupport {

    public Long getCurrentUserId() throws Exception {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String token = requestAttributes.getRequest().getHeader("token");
        return getCurrentUserId(token);
    }

    public Long getCurrentUserId(String token) throws Exception {
        Long userId= Long.parseLong(TokenUtils.verifyToken(token));
        if(userId<0){
            throw new RuntimeException("");
        }
        return userId;
    }

}
