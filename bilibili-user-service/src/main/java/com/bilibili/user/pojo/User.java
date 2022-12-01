package com.bilibili.user.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private long id;
    private String phone;
    private String email;
    private String password;
    private String salt;
    private Date createDate;
    private Date updateDate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
