package com.bridge.sys.mapper;

import com.bridge.sys.pojo.TopStructureDamageType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bridge.sys.pojo.vo.TopStructureDamageTypeVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface TopStructureDamageTypeMapper extends BaseMapper<TopStructureDamageType> {

    /**
     * 根据上部结构构件类型id获取上部结构损坏类型视图对象集
     * @param topStructureComponentId
     * @return
     */
    List<TopStructureDamageTypeVo> getTopStructureDamageTypeVosById(String topStructureComponentId);
}
