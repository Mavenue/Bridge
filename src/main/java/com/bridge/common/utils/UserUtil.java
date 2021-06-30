package com.bridge.common.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bridge.sys.mapper.UserMapper;
import com.bridge.sys.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUtil {
    @Autowired
    private UserMapper userMapper;

    public Integer getUserIdByUsername(String username) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("username", username)).getUserId();
    }
}
