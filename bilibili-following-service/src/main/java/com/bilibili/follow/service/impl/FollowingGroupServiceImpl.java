package com.bilibili.follow.service.impl;

import com.bilibili.follow.dao.FollowingGroupDao;
import com.bilibili.follow.exception.ConditionException;
import com.bilibili.follow.model.FollowingGroupModel;
import com.bilibili.follow.pojo.FollowingGroup;
import com.bilibili.follow.service.FollowingGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FollowingGroupServiceImpl implements FollowingGroupService {


    public static final String CHARSET_NAME = "UTF-8";

    @Autowired
    private FollowingGroupDao followingGroupDao;

    @Override
    public List<FollowingGroupModel> getFollowingGroupListByUserId(long userId) throws SQLException {
        List<FollowingGroupModel> followingGroupModelList=new ArrayList<>();
        List<FollowingGroup> followingGroupList=followingGroupDao.getFollowGroupByUserId(userId);
        if(followingGroupList!=null) {
            followingGroupList.forEach(followingGroup -> followingGroupModelList.add(new FollowingGroupModel(followingGroup)));
        }
        return followingGroupModelList;
    }

    @Override
    public List<FollowingGroupModel> getFollowingGroupListByType(long type, long userId) throws SQLException {
        List<FollowingGroupModel> followingGroupModelList=new ArrayList<>();
        List<FollowingGroup> followingGroupList=followingGroupDao.getFollowGroupByType(type,userId);
        if(followingGroupList!=null) {
            followingGroupList.forEach(followingGroup -> followingGroupModelList.add(new FollowingGroupModel(followingGroup)));
        }
        return followingGroupModelList;
    }

    @Override
    public Boolean addFollowingGroup(FollowingGroup followingGroup) throws SQLException {
        FollowingGroup existingFollowingGroup=followingGroupDao.getFollowGroupByNameAndUserId(followingGroup.getName(),followingGroup.getUserId());
        if(existingFollowingGroup!=null){
            throw new ConditionException("Have same name of following group");
        }
        return followingGroupDao.addFollowingGroup(followingGroup)>0;
    }

    @Override
    public Boolean deleteFollowingGroup(long groupId, long userId) throws SQLException {
        FollowingGroup existingFollowingGroup=followingGroupDao.getFollowGroupById(groupId);
        if(existingFollowingGroup==null){
            throw new ConditionException("Not found the following group");
        }
        if(userId != existingFollowingGroup.getUserId()){
            throw new ConditionException("You isn't the group owner");
        }
        return followingGroupDao.deleteFollowingGroup(groupId)>0;
    }

}
