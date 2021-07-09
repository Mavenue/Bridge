package com.bridge.sys.service;

import com.bridge.sys.pojo.BridgeDeckComponentType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bridge.sys.pojo.vo.BridgeDeckDetectionVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface IBridgeDeckComponentTypeService extends IService<BridgeDeckComponentType> {

    /**
     * 根据桥面系构件类型id获取BridgeDeckDetectionVo对象
     * @param bridgeDeckComponentId
     * @return
     */
    BridgeDeckDetectionVo getBridgeDeckDetectionVo(String bridgeDeckComponentId);
}
