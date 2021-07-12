package com.bridge.sys.service;

import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.PeriodicDetection;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bridge.sys.pojo.dto.PeriodicDetectionResultDto;
import com.bridge.sys.pojo.vo.PeriodicDetectionResultVo;

import java.security.Principal;
import java.util.List;

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
     * @param principal
     * @return
     */
    RespBean submitPeriodicDetectionResults(PeriodicDetectionResultDto periodicDetectionResultDto, Principal principal);


    /**
     * 根据桥梁id获取桥梁定期检测统计数据
     * @param bridgeId
     * @return
     */
    List<PeriodicDetection> getPeriodicDetectionResultStatistic(String bridgeId);

    /**
     * 根据桥梁id获取桥梁定期检测历史记录
     * @param bridgeId
     * @return
     */
    List<PeriodicDetectionResultVo> getPeriodicDetectionResultHistory(String bridgeId);
}
