package com.bilibili.follow.model;

import com.bilibili.follow.pojo.FollowingGroup;
import lombok.Data;

@Data
public class FollowingGroupModel {
    private Long userId;
    private Long groupId;
    private String name;

    public FollowingGroupModel(){

    }

    public FollowingGroupModel(FollowingGroup followingGroup){
        this.setGroupId(followingGroup.getId());
        this.setName(followingGroup.getName());
        this.setUserId(followingGroup.getUserId());
    }

}
