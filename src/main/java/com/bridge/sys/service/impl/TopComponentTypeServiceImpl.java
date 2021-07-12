package com.bridge.sys.service.impl;

import com.bridge.sys.mapper.TopStructureDamageTypeMapper;
import com.bridge.sys.pojo.TopComponentType;
import com.bridge.sys.mapper.TopComponentTypeMapper;
import com.bridge.sys.pojo.vo.TopStructureDamageTypeVo;
import com.bridge.sys.pojo.vo.TopStructureDetectionVo;
import com.bridge.sys.service.ITopComponentTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class TopComponentTypeServiceImpl extends ServiceImpl<TopComponentTypeMapper, TopComponentType> implements ITopComponentTypeService {

    @Autowired
    private TopComponentTypeMapper topComponentTypeMapper;

    @Autowired
    private TopStructureDamageTypeMapper topStructureDamageTypeMapper;

    /**
     * 根据上部构件类型id获取TopStructureDetectionVo对象
     * @param topStructureComponentId
     * @return
     */
    @Override
    public TopStructureDetectionVo getTopStructureDetectionVo(String topStructureComponentId) {
        TopStructureDetectionVo topStructureDetectionVo = new TopStructureDetectionVo();
        try {
            String topStructureComponentName = topComponentTypeMapper.getTopStructureComponentNameById(topStructureComponentId);
            topStructureDetectionVo.setTopStructureComponentName(topStructureComponentName);

            List<TopStructureDamageTypeVo> topStructureDamageTypeVos = topStructureDamageTypeMapper.getTopStructureDamageTypeVosById(topStructureComponentId);
            topStructureDetectionVo.setTopStructureDamageTypeVos(topStructureDamageTypeVos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return topStructureDetectionVo;
    }
}
