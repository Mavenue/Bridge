package com.bridge.sys.service;

import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.RoutineDetectionResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bridge.sys.pojo.dto.RoutineDetectionResultsDto;

import java.security.Principal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface IRoutineDetectionResultService extends IService<RoutineDetectionResult> {

    /**
     * 日常检测结果提交
     * @param routineDetectionResultsDto
     * @param principal
     * @return
     */
    RespBean insertRoutineDetectionResults(RoutineDetectionResultsDto routineDetectionResultsDto, Principal principal);
}
