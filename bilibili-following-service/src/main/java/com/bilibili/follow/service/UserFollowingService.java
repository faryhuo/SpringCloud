package com.bilibili.follow.service;


import com.bilibili.follow.pojo.UserFollowing;

import java.sql.SQLException;
import java.util.List;

public interface UserFollowingService {
    List<UserFollowing> getUserFollowingListByUserId(Long userId) throws SQLException;
    Boolean addUserFollowings(UserFollowing userFollowing) throws SQLException;
}
