package com.bilibili.follow.service.impl;
import com.bilibili.follow.FollowingApplication;
import com.bilibili.follow.pojo.UserFollowing;
import com.bilibili.follow.service.UserFollowingService;
import com.bilibili.follow.dao.UserFollowingDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.sql.SQLException;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
@ContextConfiguration(classes = {UserFollowingDao.class, FollowingApplication.class})
@SqlGroup(
        {@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = {"classpath:database/t_user_following.sql","classpath:database/t_following_group.sql"})}
)
@Slf4j
public class UserFollowingServiceImplTest {

    @Autowired
    UserFollowingService userFollowingService;


    @Test
    public void testGetUserFollowingListByUserId() throws SQLException {
        Long userId=1L;
        List<UserFollowing> userFollowingList=userFollowingService.getUserFollowingListByUserId(userId);
        log.info(userFollowingList.toString());
        Assert.assertEquals(3,userFollowingList.size());
    }
}
