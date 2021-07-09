package com.bridge.sys.mapper;

import com.bridge.sys.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bridge.sys.pojo.dto.UpdateAuthUserDto;
import com.bridge.sys.pojo.dto.UserDto;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 添加用户
     * @param userDto
     * @return
     */
    Integer addUser(UserDto userDto);

    /**
     * 更改用户权限
     * @param updateAuthUserDto
     * @return
     */
    Integer updateUserAuth(UpdateAuthUserDto updateAuthUserDto);
}
