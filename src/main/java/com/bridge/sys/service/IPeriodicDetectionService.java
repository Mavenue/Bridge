package com.bridge.sys.service;

import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.PeriodicDetection;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bridge.sys.pojo.dto.PeriodicDetectionResultDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface IPeriodicDetectionService extends IService<PeriodicDetection> {

    /**
     * 定期检测结果提交
     * @param periodicDetectionResultDto
     * @return
     */
    RespBean submitPeriodicDetectionResults(PeriodicDetectionResultDto periodicDetectionResultDto);
}
