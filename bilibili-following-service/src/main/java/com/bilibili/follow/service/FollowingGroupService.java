package com.bilibili.follow.service;


import com.bilibili.follow.pojo.FollowingGroup;
import com.bilibili.follow.pojo.UserFollowing;

import java.sql.SQLException;
import java.util.List;

public interface FollowingGroupService {
    List<FollowingGroup> getFollowingGroupListByUserId(Long userId) throws SQLException;
    List<FollowingGroup> getFollowingGroupListByType(Long type) throws SQLException;
}
