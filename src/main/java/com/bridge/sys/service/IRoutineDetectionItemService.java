package com.bridge.sys.service;

import com.bridge.sys.pojo.RoutineDetectionItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface IRoutineDetectionItemService extends IService<RoutineDetectionItem> {

    /**
     * 获取桥梁所有的日常检测项
     * @return
     */
    List<RoutineDetectionItem> getAllRoutineDetectionItems();
}
