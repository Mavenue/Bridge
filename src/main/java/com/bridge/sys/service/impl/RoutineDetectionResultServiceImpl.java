package com.bridge.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bridge.common.utils.RespBean;
import com.bridge.common.utils.UserUtil;
import com.bridge.sys.mapper.RoutineDetectionMapper;
import com.bridge.sys.mapper.UserMapper;
import com.bridge.sys.pojo.RoutineDetection;
import com.bridge.sys.pojo.RoutineDetectionResult;
import com.bridge.sys.mapper.RoutineDetectionResultMapper;
import com.bridge.sys.pojo.User;
import com.bridge.sys.pojo.dto.RoutineDetectionResultsDto;
import com.bridge.sys.service.IRoutineDetectionResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.security.Principal;

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
            if (routineDetectionMapper.insert(routineDetection) <= 0) {
                return RespBean.error("日常检测结果提交失败");
            }
            this.saveBatch(routineDetectionResultsDto.getRoutineDetectionResults());
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return RespBean.error("日常检测结果提交失败");
        }
        return RespBean.success("日常检测结果提交成功");
    }
}
