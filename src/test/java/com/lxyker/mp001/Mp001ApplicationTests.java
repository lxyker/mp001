package com.lxyker.mp001;

import com.lxyker.mp001.entity.User;
import com.lxyker.mp001.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mp001ApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setAge(2);
        user.setName("小龙");
        user.setEmail("xiaolong@163.cn");
        int insert = userMapper.insert(user);
        System.out.println("变动行数：" + insert);
    }
}
