package com.bilibili.follow.dao;

import com.bilibili.follow.pojo.UserFollowing;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface UserFollowingDao {
    List<UserFollowing> getUserFollowingListByUserId(Long userId) throws SQLException;;
}
