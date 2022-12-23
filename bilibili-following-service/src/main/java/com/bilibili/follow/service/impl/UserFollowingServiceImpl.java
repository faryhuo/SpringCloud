package com.bilibili.follow.service.impl;

import com.bilibili.common.model.JsonResponse;
import com.bilibili.follow.dao.FollowingGroupDao;
import com.bilibili.follow.exception.ConditionException;
import com.bilibili.follow.model.UserFollowingModel;
import com.bilibili.follow.pojo.FollowingGroup;
import com.bilibili.follow.pojo.UserFollowing;
import com.bilibili.follow.service.UserFollowingService;
import com.bilibili.follow.dao.UserFollowingDao;
import com.bilibili.user.model.UserModel;
import com.bilibili.user.pojo.User;
import com.springcloud.feign.api.client.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
public class UserFollowingServiceImpl implements UserFollowingService {


    public static final String CHARSET_NAME = "UTF-8";
    public static final int DEFAULT_GROUP_ID = 1;

    @Autowired
    private UserFollowingDao userFollowingDao;
    @Autowired
    private FollowingGroupDao followingGroupDao;

    @Autowired
    UserClient userClient;

    @Override
    public List<UserFollowing> getUserFollowingListByUserId(Long userId) throws SQLException {
        return userFollowingDao.getUserFollowingListByUserId(userId);
    }

    @Override
    public Boolean addUserFollowings(UserFollowing userFollowing) throws SQLException {
        Long groupId = userFollowing.getGroupId();
        if(groupId==null){
            userFollowing.setGroupId(DEFAULT_GROUP_ID);
        }else{
            FollowingGroup followingGroup=followingGroupDao.getFollowGroupById(userFollowing.getGroupId());
            if(followingGroup==null){
                throw new ConditionException("Not found the following group");
            }
        }
        JsonResponse<Boolean> userResponse = userClient.checkUserIfExisting(userFollowing.getFollowingId());
        if(!userResponse.getData()){
            throw new ConditionException("Not found the following user");
        }
        return userFollowingDao.addUserFollowing(userFollowing)>0;
    }

    @Override
    public Boolean deleteUserFollowings(long userId, long followingId) throws SQLException {
        JsonResponse<Boolean> userResponse = userClient.checkUserIfExisting(followingId);
        if(!userResponse.getData()){
            throw new ConditionException("Not found the following user");
        }
        return userFollowingDao.deleteUserFollowing(userId,followingId)>0;
    }

    @Override
    public List<UserFollowingModel> getUserFollowingListByUserIdAndGroupId(long userId, long groupId) throws SQLException {
        return null;
    }
}
