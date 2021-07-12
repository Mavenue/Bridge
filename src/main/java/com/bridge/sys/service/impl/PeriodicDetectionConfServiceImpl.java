package com.bridge.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bridge.sys.mapper.BridgeInfoMapper;
import com.bridge.sys.pojo.PeriodicDetectionConf;
import com.bridge.sys.mapper.PeriodicDetectionConfMapper;
import com.bridge.sys.pojo.vo.BottomStructureDetectionVo;
import com.bridge.sys.pojo.vo.BridgeDeckDetectionVo;
import com.bridge.sys.pojo.vo.PeriodicDetectionVo;
import com.bridge.sys.pojo.vo.TopStructureDetectionVo;
import com.bridge.sys.service.IBottomComponentTypeService;
import com.bridge.sys.service.IBridgeDeckComponentTypeService;
import com.bridge.sys.service.IPeriodicDetectionConfService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bridge.sys.service.ITopComponentTypeService;
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
public class PeriodicDetectionConfServiceImpl extends ServiceImpl<PeriodicDetectionConfMapper, PeriodicDetectionConf> implements IPeriodicDetectionConfService {

    @Autowired
    private BridgeInfoMapper bridgeInfoMapper;

    @Autowired
    private PeriodicDetectionConfMapper detectionConfMapper;

    @Autowired
    private IBridgeDeckComponentTypeService bridgeDeckComponentTypeService;

    @Autowired
    private ITopComponentTypeService topComponentTypeService;

    @Autowired
    private IBottomComponentTypeService bottomComponentTypeService;


    /**
     * 根据桥梁id获取桥梁定期检测内容
     * @param bridgeId
     * @return
     */
    @Override
    public PeriodicDetectionVo getPeriodicDetectionContents(String bridgeId) {
        PeriodicDetectionVo periodicDetectionVo = new PeriodicDetectionVo();
        try {
            Integer spanNum = bridgeInfoMapper.getBridgeSpanNumById(bridgeId);
            periodicDetectionVo.setSpanNum(spanNum);

            Integer structureId = bridgeInfoMapper.getStructureIdByBridgeId(bridgeId);

            List<PeriodicDetectionConf> bridgeDeckConfig = detectionConfMapper.selectList(new QueryWrapper<PeriodicDetectionConf>()
                    .eq("structure_id", structureId)
                    .isNotNull("bridge_deck_component_id"));
            periodicDetectionVo.setBridgeDeckDetectionVos(getBridgeDeckDetections(bridgeDeckConfig));

            List<PeriodicDetectionConf> topStructureConfig = detectionConfMapper.selectList(new QueryWrapper<PeriodicDetectionConf>()
                    .eq("structure_id", structureId)
                    .isNotNull("top_structure_component_id"));
            periodicDetectionVo.setTopStructureDetectionVos(getTopStructureDetections(topStructureConfig));


            List<PeriodicDetectionConf> bottomStructurePierConfig = detectionConfMapper.getBottomStructurePierConfig(structureId);
            periodicDetectionVo.setBottomStructurePierDetectionVos(getBottomStructureDetections(bottomStructurePierConfig));

            List<PeriodicDetectionConf> bottomStructureAbutmentConfig = detectionConfMapper.getBottomStructureAbutmentConfig(structureId);
            periodicDetectionVo.setBottomStructureAbutmentDetectionVos(getBottomStructureDetections(bottomStructureAbutmentConfig));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return periodicDetectionVo;
    }

    /**
     * 根据下部结构的配置项获取下部结构所有检测内容
     * @param bottomStructureConfig
     * @return
     */
    private List<BottomStructureDetectionVo> getBottomStructureDetections(List<PeriodicDetectionConf> bottomStructureConfig) {
        List<BottomStructureDetectionVo> bottomStructurePierDetectionVos = new ArrayList<>();
        try {
            bottomStructureConfig.forEach(config -> {
                BottomStructureDetectionVo bottomStructurePierDetectionVo = bottomComponentTypeService.getBottomStructurePierDetectionVo(config.getBottomStructureComponentId());
                bottomStructurePierDetectionVo.setWeight(config.getWeight().doubleValue());
                bottomStructurePierDetectionVos.add(bottomStructurePierDetectionVo);
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return bottomStructurePierDetectionVos;
    }

    /**
     * 根据上部结构的配置项获取上部结构所有检测内容
     * @param topStructureConfig
     * @return
     */
    private List<TopStructureDetectionVo> getTopStructureDetections(List<PeriodicDetectionConf> topStructureConfig) {
        List<TopStructureDetectionVo> topStructureDetectionVos = new ArrayList<>();
        try {
            topStructureConfig.forEach(config -> {
                TopStructureDetectionVo topStructureDetectionVo = topComponentTypeService.getTopStructureDetectionVo(config.getTopStructureComponentId());
                topStructureDetectionVo.setWeight(config.getWeight().doubleValue());
                topStructureDetectionVos.add(topStructureDetectionVo);
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return topStructureDetectionVos;
    }

    /**
     * 根据桥面系的配置项获取桥面系所有检测内容
     * @param bridgeDeckConfig
     * @return
     */
    private List<BridgeDeckDetectionVo> getBridgeDeckDetections(List<PeriodicDetectionConf> bridgeDeckConfig) {
        List<BridgeDeckDetectionVo> bridgeDeckDetectionVos = new ArrayList<>();
        bridgeDeckConfig.forEach(configs -> {
            BridgeDeckDetectionVo bridgeDeckDetectionVo = bridgeDeckComponentTypeService.getBridgeDeckDetectionVo(configs.getBridgeDeckComponentId());
            bridgeDeckDetectionVo.setWeight(configs.getWeight().doubleValue());
            bridgeDeckDetectionVos.add(bridgeDeckDetectionVo);
        });
        return bridgeDeckDetectionVos;
    }
}
