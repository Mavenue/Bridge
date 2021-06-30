package com.bridge.sys.service;

import com.bridge.sys.pojo.StructureType;
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
public interface IStructureTypeService extends IService<StructureType> {

    /**
     * 获取所有桥梁结构类型
     * @return
     */
    List<StructureType> getAllBridgeStructureTypes();

}
