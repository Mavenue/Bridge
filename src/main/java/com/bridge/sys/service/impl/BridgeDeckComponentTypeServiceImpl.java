package com.bridge.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bridge.sys.mapper.BridgeDeckDamageClassMapper;
import com.bridge.sys.mapper.BridgeDeckDamageTypeMapper;
import com.bridge.sys.pojo.BridgeDeckComponentType;
import com.bridge.sys.mapper.BridgeDeckComponentTypeMapper;
import com.bridge.sys.pojo.BridgeDeckDamageClass;
import com.bridge.sys.pojo.BridgeDeckDamageType;
import com.bridge.sys.pojo.vo.BridgeDeckDamageTypeVo;
import com.bridge.sys.pojo.vo.BridgeDeckDetectionVo;
import com.bridge.sys.service.IBridgeDeckComponentTypeService;
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
public class BridgeDeckComponentTypeServiceImpl extends ServiceImpl<BridgeDeckComponentTypeMapper, BridgeDeckComponentType> implements IBridgeDeckComponentTypeService {

    @Autowired
    private BridgeDeckDamageTypeMapper bridgeDeckDamageTypeMapper;

    @Autowired
    private BridgeDeckComponentTypeMapper bridgeDeckComponentTypeMapper;

    /**
     * 根据桥面系构件类型id获取BridgeDeckDetectionVo对象
     * @param bridgeDeckComponentId
     * @return
     */
    @Override
    public BridgeDeckDetectionVo getBridgeDeckDetectionVo(String bridgeDeckComponentId) {
        BridgeDeckDetectionVo bridgeDeckDetectionVo = new BridgeDeckDetectionVo();
        try {
            String bridgeDeckComponentName = bridgeDeckComponentTypeMapper.getBridgeDeckComponentTypeNameById(bridgeDeckComponentId);
            bridgeDeckDetectionVo.setBridgeDeckComponentName(bridgeDeckComponentName);

            List<BridgeDeckDamageTypeVo> bridgeDeckDamageTypeVos =  bridgeDeckDamageTypeMapper.getBridgeDeckDamageTypeVos(bridgeDeckComponentId);
            bridgeDeckDetectionVo.setBridgeDeckDamageTypeVos(bridgeDeckDamageTypeVos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bridgeDeckDetectionVo;
    }

}
