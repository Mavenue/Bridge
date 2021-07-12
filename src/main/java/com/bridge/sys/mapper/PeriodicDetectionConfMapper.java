package com.bridge.sys.mapper;

import com.bridge.sys.pojo.PeriodicDetectionConf;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface PeriodicDetectionConfMapper extends BaseMapper<PeriodicDetectionConf> {

    /**
     * 根据结构类型id获取下部结构桥墩配置项
     * @param structureId
     * @return
     */
    List<PeriodicDetectionConf> getBottomStructurePierConfig(Integer structureId);

    /**
     * 根据结构类型id获取下部结构桥台配置项
     * @param structureId
     * @return
     */
    List<PeriodicDetectionConf> getBottomStructureAbutmentConfig(Integer structureId);
}
