package com.bilibili.follow.service.impl;

import com.bilibili.follow.dao.FollowingGroupDao;
import com.bilibili.follow.pojo.FollowingGroup;
import com.bilibili.follow.pojo.UserFollowing;
import com.bilibili.follow.service.UserFollowingService;
import com.bilibili.follow.dao.UserFollowingDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
public class UserFollowingServiceImpl implements UserFollowingService {


    public static final String CHARSET_NAME = "UTF-8";
    public static final String DEFAULT_GROUP_TYPE = "0";

    @Autowired
    private UserFollowingDao userFollowingDao;
    @Autowired
    private FollowingGroupDao followingGroupDao;
    @Override
    public List<UserFollowing> getUserFollowingListByUserId(Long userId) throws SQLException {
        return userFollowingDao.getUserFollowingListByUserId(userId);
    }

    @Override
    public Boolean addUserFollowings(UserFollowing userFollowing) throws SQLException {
        Long groupId = userFollowing.getGroupId();
        if(groupId==null){
            FollowingGroup followingGroup=followingGroupDao.getFollowGroupByType(DEFAULT_GROUP_TYPE);
            userFollowing.setGroupId(followingGroup.getGroupId());
        }else{
            FollowingGroup followingGroup=followingGroupDao.getFollowGroupById(userFollowing.getGroupId());
            userFollowing.setGroupId(followingGroup.getGroupId());
        }
    }
}
