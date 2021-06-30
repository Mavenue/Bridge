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

    Integer addUser(UserDto userDto);

    Integer updateUserAuth(UpdateAuthUserDto updateAuthUserDto);
}
