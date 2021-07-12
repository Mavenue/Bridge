package com.bridge.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bridge.sys.pojo.Nav;
import com.bridge.sys.pojo.vo.Router;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface NavMapper extends BaseMapper<Nav> {
    /**
     * 根据用户权限类型获取路由
     * @param type
     * @return
     */
    List<Router> getRouterByUserType(Integer type);
}
