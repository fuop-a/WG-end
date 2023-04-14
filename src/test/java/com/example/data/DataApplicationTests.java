package com.example.data;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.data.entity.User;
import com.example.data.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@SpringBootTest
class DataApplicationTests {

    @Autowired
    private RedisTemplate stringRedisTemplate;
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
    }

    @Test
    public void testStringSetKey(){
        stringRedisTemplate.opsForValue().set("wuhu","shuai");
    }

    @Test
    public void testFindUser(){
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username","张三");
        List list = userService.list(queryWrapper);
        User user = (User) list.get(0);
        System.out.println(user.getPassword());

    }
}
