package com.bridge.sys.service.impl;

import com.bridge.sys.mapper.BottomStructureDamageTypeMapper;
import com.bridge.sys.pojo.BottomComponentType;
import com.bridge.sys.mapper.BottomComponentTypeMapper;
import com.bridge.sys.pojo.vo.BottomStructureDamageTypeVo;
import com.bridge.sys.pojo.vo.BottomStructureDetectionVo;
import com.bridge.sys.service.IBottomComponentTypeService;
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
public class BottomComponentTypeServiceImpl extends ServiceImpl<BottomComponentTypeMapper, BottomComponentType> implements IBottomComponentTypeService {

    @Autowired
    private BottomComponentTypeMapper bottomComponentTypeMapper;

    @Autowired
    private BottomStructureDamageTypeMapper bottomStructureDamageTypeMapper;

    /**
     * 根据下部构件类型id获取下部构件桥墩检测视图对象
     * @param bottomStructureComponentId
     * @return
     */
    @Override
    public BottomStructureDetectionVo getBottomStructurePierDetectionVo(String bottomStructureComponentId) {
        BottomStructureDetectionVo bottomStructurePierDetectionVo = new BottomStructureDetectionVo();
        try {
            String bottomStructurePierComponentName = bottomComponentTypeMapper.getBottomStructurePierComponentNameById(bottomStructureComponentId);
            bottomStructurePierDetectionVo.setBottomStructureComponentName(bottomStructurePierComponentName);

            List<BottomStructureDamageTypeVo> bottomStructurePierDamageTypeVos = bottomStructureDamageTypeMapper.getBottomStructurePierDamageTypeVosById(bottomStructureComponentId);
            bottomStructurePierDetectionVo.setBottomStructureDamageTypeVos(bottomStructurePierDamageTypeVos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bottomStructurePierDetectionVo;
    }
}
