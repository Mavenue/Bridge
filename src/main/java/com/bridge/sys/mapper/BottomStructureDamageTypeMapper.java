package com.bridge.sys.mapper;

import com.bridge.sys.pojo.BottomStructureDamageType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bridge.sys.pojo.vo.BottomStructureDamageTypeVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface BottomStructureDamageTypeMapper extends BaseMapper<BottomStructureDamageType> {

    /**
     * 根据下部结构构件类型id获取下部结构桥墩损坏类型视图对象集
     * @param bottomStructureComponentId
     * @return
     */
    List<BottomStructureDamageTypeVo> getBottomStructurePierDamageTypeVosById(String bottomStructureComponentId);
}
