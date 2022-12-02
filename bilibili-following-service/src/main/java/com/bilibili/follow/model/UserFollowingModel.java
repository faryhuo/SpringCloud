package com.bilibili.follow.model;

import com.bilibili.follow.pojo.UserFollowing;
import com.bilibili.user.model.UserInfoModel;
import lombok.Data;

import java.util.List;

@Data
public class UserFollowingModel {
    private Long userId;
    private Long groupId;
    List<UserInfoModel> followingUsers;

    public UserFollowingModel(){

    }

    public UserFollowingModel(List<UserFollowing> userFollowingList){
        if(userFollowingList!=null){
            userFollowingList.forEach((userFollowing -> {
                UserInfoModel userInfo=new UserInfoModel();
                userInfo.setId(userFollowing.getFollowingId());
            }));
        }
    }

}
