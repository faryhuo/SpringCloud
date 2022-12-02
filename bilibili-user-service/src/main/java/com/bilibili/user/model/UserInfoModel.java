package com.bilibili.user.model;

import lombok.Data;

@Data
public class UserInfoModel {
    private Long id;
    private String userId;
    private String name;
    private String avatar;
    private String sign;
    private String gender;
    private String birth;
}


