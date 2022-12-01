package com.bilibili.user.service.impl;

import com.bilibili.common.utils.MD5Utils;
import com.bilibili.common.utils.RSAUtils;
import com.bilibili.common.utils.TokenUtils;
import com.bilibili.user.dao.UserDao;
import com.bilibili.user.exception.EncryptException;
import com.bilibili.user.model.UserModel;
import com.bilibili.user.pojo.User;
import com.bilibili.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    public static final String CHARSET_NAME = "UTF-8";

    @Autowired
    private UserDao userDao;

    @Override
    public boolean addUser(UserModel userModel) throws SQLException,EncryptException {
        String phone=userModel.getPhone();
        User existingUser=userDao.getUserByPhone(phone);
        if(existingUser!=null){
            return false;
        }
        Date now=new Date();
        String salt= String.valueOf(now.getTime());
        String md5Pwd = null;
        try {
            String password = RSAUtils.decrypt(userModel.getPassword());
            md5Pwd= MD5Utils.sign(password,salt, CHARSET_NAME);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new EncryptException("Failed to encrypt the password");
        }
        String email=userModel.getEmail();
        User user=new User();
        user.setEmail(email);
        user.setPassword(md5Pwd);
        user.setPhone(phone);
        user.setSalt(salt);
        user.setCreateDate(now);
        user.setUpdateDate(now);
        int result=userDao.addUser(user);
        return result>0;
    }

    @Override
    public User getUserByPhone(String phone) throws SQLException {
        return userDao.getUserByPhone(phone);
    }

    @Override
    public String login(String phone, String password) throws Exception {
        User existingUser=userDao.getUserByPhone(phone);
        if(existingUser==null){
            return "";
        }else{
            String existingPassword= existingUser.getPassword();
            String md5Pwd=null;
            try {
                md5Pwd=MD5Utils.sign(RSAUtils.decrypt(password),existingUser.getSalt(), CHARSET_NAME);
            }catch (Exception e){
                log.error(e.getMessage(),e);
                throw new EncryptException("Failed to decrypt the password");
            }
            if(StringUtils.equals(md5Pwd,existingPassword)){
                return TokenUtils.generateToken(String.valueOf(existingUser.getId()));
            }else{
                return "";
            }
        }
    }

    @Override
    public User getUserById(Long id) throws SQLException {
        return userDao.getUserById(id);
    }
}
