package com.bilibili.follow.dao;

import com.bilibili.follow.pojo.FollowingGroup;

import java.sql.SQLException;
import java.util.List;

public interface FollowingGroupDao {
    List<FollowingGroup> getFollowGroupByUserId(Long userId) throws SQLException;
    List<FollowingGroup> getFollowGroupByType(long type ,long userId) throws SQLException;

    FollowingGroup getFollowGroupById(Long id) throws SQLException;
    FollowingGroup getFollowGroupByNameAndUserId(String name,Long userId);
    Long addFollowingGroup(FollowingGroup followingGroup) throws SQLException;
    Long deleteFollowingGroup(Long id) throws SQLException;
}
