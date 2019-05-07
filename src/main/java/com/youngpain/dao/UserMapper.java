package com.youngpain.dao;

import com.youngpain.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 负责用户的登录和注册
 */
@Mapper
public interface UserMapper {

    // 添加用户
    long insertUser(User user);

    // 根据用户名和密码查询该用户是否存在
    long getUser(User user);

    // 根据用户名查询该用户是否存在，如果存在则不能注册
    long getUserByUsername(String username);

}
