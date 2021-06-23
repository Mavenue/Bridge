package com.bridge.service.impl;

import com.bridge.pojo.User;
import com.bridge.mapper.UserMapper;
import com.bridge.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
