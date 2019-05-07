package com.example.weather;

import com.youngpain.bean.User;
import com.youngpain.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        User user = new User(null, "1741248769", "0110");
        boolean b = userService.checkRegister(user);
        if (b) {
            System.out.println("注册用户成功");
        }
    }

}
