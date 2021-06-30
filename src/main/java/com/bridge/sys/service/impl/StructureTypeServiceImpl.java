package com.bridge.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bridge.sys.pojo.StructureType;
import com.bridge.sys.mapper.StructureTypeMapper;
import com.bridge.sys.service.IStructureTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
@Service
public class StructureTypeServiceImpl extends ServiceImpl<StructureTypeMapper, StructureType> implements IStructureTypeService {

    @Autowired
    private StructureTypeMapper structureTypeMapper;

    /**
     * 获取所有桥梁结构类型
     * @return
     */
    @Override
    public List<StructureType> getAllBridgeStructureTypes() {
        return structureTypeMapper.selectList(new QueryWrapper<StructureType>(null));
    }
}
