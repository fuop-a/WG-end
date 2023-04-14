package com.example.data.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.data.entity.User;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-14 13:43:43
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

