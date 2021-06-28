package com.bridge.sys.controller;


import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.User;
import com.bridge.sys.pojo.vo.LoginInfo;
import com.bridge.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/login")
    public RespBean login(@RequestBody LoginInfo loginInfo) {
        return userService.login(loginInfo);
    }
    @GetMapping(value = "/{username}")
    public User getUserInfo(@PathVariable String username) {
        if (username == null) {
            return null;
        }
        return userService.getUserInfo(username);
    }
}
