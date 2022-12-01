package com.bilibili.user.dao;

import com.bilibili.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface UserDao {
    User getUserByPhone(String phone) throws SQLException;;
    int addUser(User user) throws SQLException;
    User getUserById(Long id) throws SQLException;;
}
