package com.bridge.sys.service.impl;

import com.bridge.common.utils.RespBean;
import com.bridge.common.utils.UserUtil;
import com.bridge.sys.mapper.RoutineDetectionMapper;
import com.bridge.sys.pojo.RoutineDetection;
import com.bridge.sys.pojo.RoutineDetectionResult;
import com.bridge.sys.mapper.RoutineDetectionResultMapper;
import com.bridge.sys.pojo.dto.RoutineDetectionResultsDto;
import com.bridge.sys.service.IRoutineDetectionResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.security.Principal;
import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
@Service
public class RoutineDetectionResultServiceImpl extends ServiceImpl<RoutineDetectionResultMapper, RoutineDetectionResult> implements IRoutineDetectionResultService {

    @Autowired
    private RoutineDetectionMapper routineDetectionMapper;

    @Autowired
    private UserUtil userUtil;

    /**
     * 日常检测结果提交
     * @param routineDetectionResultsDto
     * @param principal
     * @return
     */
    @Transactional
    @Override
    public RespBean insertRoutineDetectionResults(RoutineDetectionResultsDto routineDetectionResultsDto, Principal principal) {
        if (principal == null) {
            return RespBean.error("日常检测结果提交失败, 权限不足");
        }
        try {
            Integer userId = userUtil.getUserIdByUsername(principal.getName());
            RoutineDetection routineDetection = routineDetectionResultsDto.getRoutineDetection();
            routineDetection.setUserId(userId);
            routineDetection.setRoutineDetectionDate(LocalDate.now());
            if (routineDetectionMapper.insert(routineDetection) <= 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return RespBean.error("日常检测结果提交失败");
            }
            String bridgeId = routineDetection.getBridgeId();
            routineDetectionResultsDto.getRoutineDetectionResults().forEach(detectionResult -> {
                detectionResult.setRoutineDetectionDate(LocalDate.now());
                detectionResult.setBridgeId(bridgeId);
            });
            this.saveBatch(routineDetectionResultsDto.getRoutineDetectionResults());
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return RespBean.error("日常检测结果提交失败");
        }
        return RespBean.success("日常检测结果提交成功");
    }
}
