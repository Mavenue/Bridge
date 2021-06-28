package com.bridge.sys.service;

import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bridge.sys.pojo.vo.LoginInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface IUserService extends IService<User> {

    RespBean login(LoginInfo loginInfo);

    User getUserInfo(String username);
}
