package com.bridge.sys.mapper;

import com.bridge.sys.pojo.BridgeDeckComponentType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface BridgeDeckComponentTypeMapper extends BaseMapper<BridgeDeckComponentType> {

    /**
     * 根据桥面系构件类型id获取构建名
     * @param bridgeDeckComponentId
     * @return
     */
    String getComponentTypeNameById(String bridgeDeckComponentId);
}
