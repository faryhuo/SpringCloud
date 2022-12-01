package com.bilibili.follow.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class FollowingGroup {
    private Long id;
    private Long userId;
    private Long groupId;
    private String name;
    private Date createDate;
    private Date updateDate;
}
