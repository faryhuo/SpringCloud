package com.bilibili.user.service;


import com.bilibili.user.exception.EncryptException;
import com.bilibili.user.model.UserModel;
import com.bilibili.user.pojo.User;

import java.sql.SQLException;

public interface UserService {
    boolean addUser(UserModel user)  throws SQLException, EncryptException;
    User getUserByPhone(String phone) throws SQLException;
    String login(String phone,String password) throws Exception;
    User getUserById(Long id) throws SQLException;
}
