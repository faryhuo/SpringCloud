package com.bilibili.follow.service;


import com.bilibili.follow.model.FollowingGroupModel;
import com.bilibili.follow.pojo.FollowingGroup;

import java.sql.SQLException;
import java.util.List;

public interface FollowingGroupService {
    List<FollowingGroupModel> getFollowingGroupListByUserId(long userId) throws SQLException;
    List<FollowingGroupModel> getFollowingGroupListByType(long type, long userId) throws SQLException;
    Boolean addFollowingGroup(FollowingGroup followingGroup) throws SQLException;
    Boolean deleteFollowingGroup(long groupId,long userId) throws SQLException;
}
