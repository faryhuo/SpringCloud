package com.bilibili.user.service.impl;
import com.bilibili.common.utils.RSAUtils;
import com.bilibili.user.UserApplication;
import com.bilibili.user.dao.UserDao;
import com.bilibili.user.exception.EncryptException;
import com.bilibili.user.model.UserModel;
import com.bilibili.user.pojo.User;
import com.bilibili.user.service.UserService;
import com.bilibili.user.utils.UserSupport;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.sql.SQLException;

@ActiveProfiles("test")
@SpringBootTest
@ContextConfiguration(classes = {UserDao.class, UserApplication.class})
@SqlGroup(
        {@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = "classpath:database/t_user.sql")}
)
@Slf4j
public class UserServiceImplTest {


    @Autowired
    UserService userService;

    @Autowired
    UserSupport userSupport;


    @Test
    public void testAddUser() throws Exception {
        UserModel userModel =new UserModel();
        String password="3333";
        String encodePwd= RSAUtils.encrypt(password);
        userModel.setEmail("111");
        userModel.setPhone("2222");
        userModel.setPassword(encodePwd);
        Boolean result=userService.addUser(userModel);
        Assert.assertEquals(true,result);
    }

    @Test
    public void testGetUserByPhone() throws Exception {
        testAddUser();
        User user=userService.getUserByPhone("2222");
        log.info(user.toString());
        Assert.assertNotNull(user);
    }

    @Test
    public void testLogin() throws Exception {
        testAddUser();
        String password="3333";
        String encodePwd= RSAUtils.encrypt(password);
        String result=userService.login("2222",encodePwd);
        log.info(result);
        Assert.assertEquals(true, StringUtils.isNotBlank(result));
    }

    @Test
    public void testGetUserById() throws Exception {
        testAddUser();
        String password="3333";
        String encodePwd= RSAUtils.encrypt(password);
        String token=userService.login("2222",encodePwd);
        User user=userService.getUserById(userSupport.getCurrentUserId(token));
        log.info(user.toString());
        Assert.assertNotNull(user);
    }
}
