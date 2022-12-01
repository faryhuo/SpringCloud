package com.bilibili.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserModel {
    private long id;
    private String phone;
    private String email;
    private String password;
}
