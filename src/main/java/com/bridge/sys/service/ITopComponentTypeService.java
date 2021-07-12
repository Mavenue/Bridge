package com.bridge.sys.service;

import com.bridge.sys.pojo.TopComponentType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bridge.sys.pojo.vo.TopStructureDetectionVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface ITopComponentTypeService extends IService<TopComponentType> {

    /**
     *  根据上部构件类型id获取TopStructureDetectionVo对象
     * @param topStructureComponentId
     * @return
     */
    TopStructureDetectionVo getTopStructureDetectionVo(String topStructureComponentId);
}
