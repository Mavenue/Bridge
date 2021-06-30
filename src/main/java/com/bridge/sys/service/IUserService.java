package com.bridge.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bridge.sys.pojo.dto.UpdateAuthUserDto;
import com.bridge.sys.pojo.dto.UserDto;

import java.security.Principal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface IUserService extends IService<User> {


    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @return
     */
    RespBean login(String username, String password);

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    User getUserInfoByUsername(String username);

    /**
     * 添加用户
     * @param userDto
     * @return
     */
    RespBean addUser(UserDto userDto);

    /**
     * 获取所有用户信息
     * @return
     */
    Page<User> getAllUserInfo(long current, long size);

    /**
     * 修改用户权限
     * @param updateAuthUserDto
     * @param principal
     * @return
     */
    RespBean updateUserAuth(UpdateAuthUserDto updateAuthUserDto, Principal principal);

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    User getUserInfoById(Integer userId);
}
