package com.bridge.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bridge.common.utils.JwtUtil;
import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.User;
import com.bridge.sys.mapper.UserMapper;
import com.bridge.sys.pojo.dto.UpdateAuthUserDto;
import com.bridge.sys.pojo.dto.UserDto;
import com.bridge.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
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
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @return
     */
    @Override
    public RespBean login(String username, String password) {
        //登录判断
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (userDetails == null || !passwordEncoder.matches(password, userDetails.getPassword())) {
            return RespBean.error("用户名或密码不正确");
        }
        if (!userDetails.isEnabled()) {
            return RespBean.error("账号被禁用，请联系管理员");
        }

        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //返回token
        String token = jwtUtil.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return RespBean.success("登录成功", tokenMap);
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @Override
    public User getUserInfoByUsername(String username) {

        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        return user;
    }

    /**
     * 添加用户
     * @param userDto
     * @return
     */
    @Override
    public RespBean addUser(UserDto userDto) {
        Integer existTheUser = userMapper.selectCount(new QueryWrapper<User>().eq("username", userDto.getUsername()));
        if (existTheUser > 0) {
            return RespBean.error("用户名已存在");
        }
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);
        try {
            if (userMapper.addUser(userDto) > 0) {
                return RespBean.success("添加用户成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("添加用户失败");
        }
        return RespBean.error("添加用户失败");
    }

    /**
     * 获取所有用户信息
     * @return
     */
    @Override
    public Page<User> getAllUserInfo(long current, long size) {
        return userMapper.selectPage(new Page<User>(current, size, userMapper.selectCount(null)),
                new QueryWrapper<User>(null));
    }

    /**
     * 修改用户权限
     * @param updateAuthUserDto
     * @param principal
     * @return
     */
    @Override
    public RespBean updateUserAuth(UpdateAuthUserDto updateAuthUserDto, Principal principal) {
        if (principal == null) {
            return RespBean.error("权限不足");
        }
        String currentUsername = principal.getName();
        User currentUserInfo = userMapper.selectOne(new QueryWrapper<User>().eq("username", currentUsername));
        User updateAuthUser = userMapper.selectOne(new QueryWrapper<User>().eq("user_id", updateAuthUserDto.getUserId()));
        if (currentUserInfo == null || updateAuthUser == null) {
            return RespBean.error("修改用户权限失败");
        }
        if (currentUserInfo.getType() != 0) {
            return RespBean.error("权限不足");
        } else if (updateAuthUser.getType() == 0) {
            return RespBean.error("不能修改系统管理员的权限");
        } else if (updateAuthUserDto.getType() == 0) {
            return RespBean.error("不能修改将用户权限修改为系统管理员");
        }
        try {
            if (userMapper.updateUserAuth(updateAuthUserDto) > 0) {
                return RespBean.success("修改用户权限成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RespBean.success("修改用户权限失败");
    }

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    @Override
    public User getUserInfoById(Integer userId) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("user_id", userId));
    }


}
