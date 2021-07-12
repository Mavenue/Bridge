package com.bridge.sys.mapper;

import com.bridge.sys.pojo.TopComponentType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface TopComponentTypeMapper extends BaseMapper<TopComponentType> {

    /**
     * 根据上部结构构件id获取上部结构构件名
     * @param topStructureComponentId
     * @return
     */
    String getTopStructureComponentNameById(String topStructureComponentId);
}
