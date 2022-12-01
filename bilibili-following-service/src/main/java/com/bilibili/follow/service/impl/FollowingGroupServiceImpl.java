package com.bilibili.follow.service.impl;

import com.bilibili.follow.dao.FollowingGroupDao;
import com.bilibili.follow.pojo.FollowingGroup;
import com.bilibili.follow.service.FollowingGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
public class FollowingGroupServiceImpl implements FollowingGroupService {


    public static final String CHARSET_NAME = "UTF-8";

    @Autowired
    private FollowingGroupDao followingGroupDao;

    @Override
    public List<FollowingGroup> getFollowingGroupListByUserId(Long userId) throws SQLException {
        return followingGroupDao.getFollowGroupByUserId(userId);
    }

    @Override
    public List<FollowingGroup> getFollowingGroupListByType(Long type) throws SQLException {
        return followingGroupDao.getFollowGroupByType(type);
    }
}
