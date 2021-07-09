package com.bridge.sys.service;

import com.bridge.sys.pojo.PeriodicDetectionConf;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bridge.sys.pojo.vo.PeriodicDetectionVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface IPeriodicDetectionConfService extends IService<PeriodicDetectionConf> {

    /**
     * 根据桥梁id获取桥梁定期检测内容
     * @param bridgeId
     * @return
     */
    PeriodicDetectionVo getPeriodicDetectionContents(String bridgeId);
}
