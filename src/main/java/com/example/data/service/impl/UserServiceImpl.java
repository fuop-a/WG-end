package com.example.data.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.data.mapper.UserMapper;
import com.example.data.entity.User;
import com.example.data.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-04-14 13:43:46
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

