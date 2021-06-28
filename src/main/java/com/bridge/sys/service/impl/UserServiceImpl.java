package com.bridge.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bridge.common.utils.JWTUtil;
import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.User;
import com.bridge.sys.mapper.UserMapper;
import com.bridge.sys.pojo.vo.LoginInfo;
import com.bridge.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JWTUtil jwtUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public RespBean login(LoginInfo loginInfo) {
        QueryWrapper<User> eq = new QueryWrapper<User>().eq("username", loginInfo.getUsername()).eq("password", loginInfo.getPassword());
        if (userMapper.selectCount(eq) > 0) {
            String token = jwtUtil.generateToken(loginInfo.getUsername());
            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("token", token);
            tokenMap.put("tokenHead", tokenHead);
            return RespBean.success("登陆成功", tokenMap);
        }
        return RespBean.error("用户名或密码不正确");
    }

    @Override
    public User getUserInfo(String username) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        user.setPassword(null);
        return user;
    }
}
