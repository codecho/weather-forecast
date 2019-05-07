package com.youngpain.controller;

import com.youngpain.bean.User;
import com.youngpain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Author pain
 * @Date 2019/1/3 16:08
 * @Version 1.0
 **/
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 负责Android端登录请求
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 根据用户名和密码查询该用户是否存在
        User user = new User(null, username, password);
        boolean canLogin = userService.checkLogin(user);
        // 若该用户存在返回登录成功信息
        if (canLogin) {
            return "LOGIN_SUCCESS";
        }
        // 若该用户不存在返回登录失败信息
        return "LOGIN_FAIL";
    }

    /**
     * 负责Android端注册请求
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 查询该用户名是否存在，若存在返回用户已存在信息
        if (userService.checkExistUserName(username)) {
            return "USER_EXIST";
        }

        // 添加用户
        User user = new User(null, username, password);
        boolean canRegister = userService.checkRegister(user);
        // 添加成功返回成功信息
        if (canRegister) {
            return "REG_SUCCESS";
        }
        // 添加失败返回失败信息
        return "REG_FAIL";
    }
}
