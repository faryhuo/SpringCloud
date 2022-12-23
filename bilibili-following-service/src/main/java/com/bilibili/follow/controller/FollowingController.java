package com.bilibili.follow.controller;

import com.bilibili.common.model.JsonResponse;
import com.bilibili.common.utils.UserSupport;
import com.bilibili.follow.dao.FollowingGroupDao;
import com.bilibili.follow.model.FollowingGroupModel;
import com.bilibili.follow.model.UserFollowingModel;
import com.bilibili.follow.pojo.FollowingGroup;
import com.bilibili.follow.pojo.UserFollowing;
import com.bilibili.follow.service.FollowingGroupService;
import com.bilibili.follow.service.UserFollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FollowingController {

    @Autowired
    FollowingGroupService followingGroupService;

    @Autowired
    UserFollowingService userFollowingService;

    @PostMapping("/following-group")
    public JsonResponse<Boolean> addFollowingGroup(@RequestBody FollowingGroup followingGroup) throws SQLException {
        return JsonResponse.ok(followingGroupService.addFollowingGroup(followingGroup));
    }

    @DeleteMapping("/following-group")
    public JsonResponse<Boolean> deleteFollowingGroup(Long groupId) throws Exception {
        Long userId= UserSupport.getCurrentUserId();
        return JsonResponse.ok(followingGroupService.deleteFollowingGroup(groupId,userId));
    }

    @GetMapping("/following-groups")
    public JsonResponse<List<FollowingGroupModel>> getFollowingGroupByType() throws Exception {
        Long userId= UserSupport.getCurrentUserId();
        return JsonResponse.ok(followingGroupService.getFollowingGroupListByUserId(userId));
    }

    @PostMapping("/user-following")
    public JsonResponse<Boolean> addUserFollowing(@RequestBody UserFollowing userFollowing) throws SQLException {
        return JsonResponse.ok(userFollowingService.addUserFollowings(userFollowing));
    }

    @DeleteMapping("/user-following")
    public JsonResponse<Boolean> deleteUserFollowing(Long followingId) throws Exception {
        Long userId= UserSupport.getCurrentUserId();
        return JsonResponse.ok(userFollowingService.deleteUserFollowings(userId,followingId));
    }


    @GetMapping("/user-followings")
    public JsonResponse<List<UserFollowingModel>> getUserFollowings(Long groupId) throws Exception {
        Long userId= UserSupport.getCurrentUserId();
        return JsonResponse.ok(userFollowingService.getUserFollowingListByUserIdAndGroupId(userId,groupId));
    }


}
