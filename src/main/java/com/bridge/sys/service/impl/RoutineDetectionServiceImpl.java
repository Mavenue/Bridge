package com.bridge.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bridge.common.utils.RespBean;
import com.bridge.sys.mapper.RoutineDetectionResultMapper;
import com.bridge.sys.pojo.RoutineDetection;
import com.bridge.sys.mapper.RoutineDetectionMapper;
import com.bridge.sys.pojo.dto.RoutineDetectionResultsDto;
import com.bridge.sys.pojo.vo.RoutineDetectionHistoryVo;
import com.bridge.sys.service.IRoutineDetectionResultService;
import com.bridge.sys.service.IRoutineDetectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
@Service
public class RoutineDetectionServiceImpl extends ServiceImpl<RoutineDetectionMapper, RoutineDetection> implements IRoutineDetectionService {

    @Autowired
    private RoutineDetectionMapper routineDetectionMapper;

    /**
     * 根据桥梁id分页获取该桥梁的所有日常监测记录信息
     * @param current
     * @param size
     * @param bridgeId
     * @return
     */
    @Override
    public Page<RoutineDetectionHistoryVo> getRoutineDetectionHistoryByBridgeId(Long current, Long size, String bridgeId) {
        List<RoutineDetectionHistoryVo> routineDetectionHistory = routineDetectionMapper.getRoutineDetectionHistoryByBridgeId(bridgeId);
        Page<RoutineDetectionHistoryVo> routineDetectionHistoryVoPage = new Page<>(current, size);
        Integer total = routineDetectionMapper.selectCount(new QueryWrapper<RoutineDetection>().eq("bridge_id", bridgeId));
        routineDetectionHistoryVoPage.setTotal(total);
        routineDetectionHistoryVoPage.setRecords(routineDetectionHistory);
        return routineDetectionHistoryVoPage;
    }
}
