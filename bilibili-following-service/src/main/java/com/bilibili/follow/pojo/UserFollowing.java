package com.bilibili.follow.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class UserFollowing {
    private long id;
    private long userId;
    private long followingId;
    private long groupId;
    private Date createDate;
    private Date updateDate;

}
