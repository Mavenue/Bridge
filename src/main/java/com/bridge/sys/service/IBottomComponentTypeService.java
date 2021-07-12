package com.bridge.sys.service;

import com.bridge.sys.pojo.BottomComponentType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bridge.sys.pojo.vo.BottomStructureDetectionVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface IBottomComponentTypeService extends IService<BottomComponentType> {

    /**
     * 根据下部构件类型id获取下部构件桥墩检测视图对象
     * @param bottomStructureComponentId
     * @return
     */
    BottomStructureDetectionVo getBottomStructurePierDetectionVo(String bottomStructureComponentId);
}
