package com.bilibili.follow.dao;

import com.bilibili.follow.pojo.FollowingGroup;

import java.sql.SQLException;
import java.util.List;

public interface FollowingGroupDao {
    List<FollowingGroup> getFollowGroupByUserId(Long userId) throws SQLException;
    List<FollowingGroup> getFollowGroupByType(Long type) throws SQLException;

    FollowingGroup getFollowGroupById(Long id) throws SQLException;

}
