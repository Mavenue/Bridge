package com.bridge.sys.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.User;
import com.bridge.sys.pojo.dto.LoginDto;
import com.bridge.sys.pojo.dto.UpdateAuthUserDto;
import com.bridge.sys.pojo.dto.UserDto;
import com.bridge.sys.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
@RestController
@RequestMapping("/user")
@Api(tags = "UserController")
public class UserController {

    @Autowired
    private IUserService userService;


    @ApiOperation(value = "获取所有用户信息")
    @GetMapping(value = "/all-info/{current}/{size}")
    public Page<User> getAllUserInfo(@PathVariable long current, @PathVariable long size) {
        return userService.getAllUserInfo(current, size);
    }

    @ApiOperation(value = "根据用户id查询用户信息")
    @GetMapping(value = "/{userId}")
    public User getUserInfoById(@PathVariable Integer userId) {
        return userService.getUserInfoById(userId);
    }

    @ApiOperation(value = "根据用户名查询用户信息")
    @GetMapping(value = "/{username}")
    public User getUserInfoByUsername(@PathVariable String username) {
        User userInfo = userService.getUserInfoByUsername(username);
        if (userInfo != null) {
            userInfo.setPassword(null);
        }
        return userInfo;
    }

    @ApiOperation(value = "修改用户权限")
    @PutMapping(value = "/update")
    public RespBean updateUserAuth(@RequestBody UpdateAuthUserDto updateAuthUserDto, Principal principal) {
        return userService.updateUserAuth(updateAuthUserDto, principal);
    }

    @ApiOperation(value = "登录后返回token")
    @PostMapping(value = "/login")
    public RespBean login(@RequestBody LoginDto loginDto) {
        return userService.login(loginDto.getUsername(), loginDto.getPassword());
    }

    @ApiOperation(value = "添加用户")
    @PostMapping(value = "/register")
    public RespBean addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @ApiOperation(value = "用户注销")
    @PostMapping(value = "/logout")
    public RespBean logout() {
        return RespBean.success("注销成功");
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping(value = "/info")
    public User getUserInfo(Principal principal) {
        if (principal == null) {
            return null;
        }
        String username = principal.getName();
        User user = userService.getUserInfoByUsername(username);
        if (user != null) {
            user.setPassword(null);
        }
        return user;
    }
}
