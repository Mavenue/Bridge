package com.bridge.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.RoutineDetection;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bridge.sys.pojo.dto.RoutineDetectionResultsDto;
import com.bridge.sys.pojo.vo.RoutineDetectionHistoryVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface IRoutineDetectionService extends IService<RoutineDetection> {

    /**
     * 根据桥梁id分页获取该桥梁的所有日常监测记录信息
     * @param bridgeId
     * @return
     */
    List<RoutineDetectionHistoryVo> getRoutineDetectionHistoryByBridgeId(String bridgeId);
}
