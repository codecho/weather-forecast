package com.youngpain.service;

import com.youngpain.bean.User;
import com.youngpain.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    // 检查用户名和密码是否正确，正确则允许登录
    public boolean checkLogin(User user) {
        return userMapper.getUser(user) != 0;
    }

    // 检查用户名是否存在，存在则不允许注册
    public boolean checkExistUserName(String username) {
        return userMapper.getUserByUsername(username) != 0;
    }

    // 检查用户是否添加成功
    public boolean checkRegister(User user) {
        return userMapper.insertUser(user) != 0;
    }

}
