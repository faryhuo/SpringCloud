package com.bilibili.follow.model;

import lombok.Data;

import java.util.List;

@Data
public class UserFollowingModel {
    private Long userId;
    List<FollowingInfo> followingInfoList;
}
