package com.bridge.sys.mapper;

import com.bridge.sys.pojo.RoutineDetection;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bridge.sys.pojo.vo.RoutineDetectionHistoryVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface RoutineDetectionMapper extends BaseMapper<RoutineDetection> {

    /**
     * 根据桥梁id获取该桥梁的所有日常监测记录信息
     * @param bridgeId
     * @return
     */
    List<RoutineDetectionHistoryVo> getRoutineDetectionHistoryByBridgeId(String bridgeId);
}
