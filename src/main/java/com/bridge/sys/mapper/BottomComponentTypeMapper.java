package com.bridge.sys.mapper;

import com.bridge.sys.pojo.BottomComponentType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface BottomComponentTypeMapper extends BaseMapper<BottomComponentType> {

    /**
     * 根据下部结构构件id获取下部结构构件名
     * @param bottomStructureComponentId
     * @return
     */
    String getBottomStructurePierComponentNameById(String bottomStructureComponentId);
}
