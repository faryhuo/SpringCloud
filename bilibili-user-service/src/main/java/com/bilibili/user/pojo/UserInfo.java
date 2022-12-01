package com.bilibili.user.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Long id;
    private String userId;
    private String name;
    private String avatar;
    private String sign;
    private String gender;
    private String birth;
    private Date createDate;
    private Date updateDate;
}
