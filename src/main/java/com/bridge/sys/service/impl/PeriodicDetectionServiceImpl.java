package com.bridge.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bridge.common.utils.RespBean;
import com.bridge.sys.mapper.*;
import com.bridge.sys.pojo.*;
import com.bridge.sys.pojo.dto.BottomStructureDetectionDto;
import com.bridge.sys.pojo.dto.BridgeDeckDetectionDto;
import com.bridge.sys.pojo.dto.PeriodicDetectionResultDto;
import com.bridge.sys.pojo.dto.TopStructureDetectionDto;
import com.bridge.sys.pojo.vo.*;
import com.bridge.sys.service.IBottomStructureDetectionResultService;
import com.bridge.sys.service.IBridgeDeckDetectionResultService;
import com.bridge.sys.service.IPeriodicDetectionService;
import com.bridge.sys.service.ITopStructureDetectionResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.security.Principal;
import java.time.LocalDate;
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
public class PeriodicDetectionServiceImpl extends ServiceImpl<PeriodicDetectionMapper, PeriodicDetection> implements IPeriodicDetectionService {

    @Autowired
    private BridgeInfoMapper bridgeInfoMapper;

    @Autowired
    private PeriodicDetectionMapper periodicDetectionMapper;

    @Autowired
    private StructureWeightMapper structureWeightMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PeriodicDetectionConfMapper detectionConfMapper;

    @Autowired
    private ITopStructureDetectionResultService topStructureDetectionResultService;

    @Autowired
    private IBridgeDeckDetectionResultService bridgeDeckDetectionResultService;

    @Autowired
    private IBottomStructureDetectionResultService bottomStructureDetectionResultService;

    /**
     * 定期检测结果提交
     * @param periodicDetectionResultDto
     * @param principal
     * @return
     */
    @Transactional
    @Override
    public RespBean submitPeriodicDetectionResults(PeriodicDetectionResultDto periodicDetectionResultDto, Principal principal) {
        if (principal == null) {
            return RespBean.error("定期检测结果提交失败，权限不足");
        }
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", principal.getName()));
        if (user == null || user.getType() != 3) {
            return RespBean.error("定期检测结果提交失败，权限不足");
        }

        //求桥面系的bci和bsi
        List<Integer> mdp_h = getBridgeDeckMdp_h(periodicDetectionResultDto.getBridgeDeckDetectionDtoList());
        Integer bridgeDeckBsi = getBridgeDeckBsi(mdp_h);
        Integer bridgeDeckBci = getBridgeDeckBci(mdp_h, periodicDetectionResultDto.getBridgeDeckDetectionDtoList());

        //求上部结构的bci和bsi
        List<Integer> topSci_si = getTopStructureBci_si(periodicDetectionResultDto.getTopStructureDetectionDtoList());
        Integer topStructureBsi = getTopStructureBsi(topSci_si);
        Integer topStructureBci = getTopStructureBci(topSci_si);

        //求下部结构bci和bsi
        List<Integer> bottomPierBci_si = getBottomStructureBci_si(periodicDetectionResultDto.getBottomStructurePierDetectionDtoList());
        List<Integer> bottomAbutmentBci_si = getBottomStructureBci_si(periodicDetectionResultDto.getBottomStructureAbutmentDetectionDtoList());
        Integer bottomPierBci = getBottomStructureBci(bottomPierBci_si);
        Integer bottomAbutmentBci = getBottomStructureBci(bottomAbutmentBci_si);
        Integer bottomPierBsi = getBottomStructureBsi(bottomPierBci_si);
        Integer bottomAbutmentBsi = getBottomStructureBsi(bottomAbutmentBci_si);
        Integer bottomBci = (bottomAbutmentBci + bottomPierBci) / 2;
        Integer bottomBsi = Math.min(bottomAbutmentBsi, bottomPierBsi);

        PeriodicDetection periodicDetection = new PeriodicDetection();
        try {
            String bridgeId = periodicDetectionResultDto.getBridgeId();
            Integer structureId =  bridgeInfoMapper.getStructureIdByBridgeId(bridgeId);
            StructureWeight structureWeight = structureWeightMapper.selectOne(new QueryWrapper<StructureWeight>().eq("structure_id", structureId));

            Integer bci = getBciOrBsi(structureWeight, bridgeDeckBci, topStructureBci, bottomBci);
            Integer bsi = getBciOrBsi(structureWeight, bridgeDeckBsi, topStructureBsi, bottomBsi);
            periodicDetection.setPeriodicDetectionDate(LocalDate.now());
            periodicDetection.setBridgeId(periodicDetectionResultDto.getBridgeId());
            periodicDetection.setUserId(user.getUserId());
            periodicDetection.setBridgeDeckBci(bridgeDeckBci);
            periodicDetection.setBridgeDeckBsi(bridgeDeckBsi);
            periodicDetection.setTopBci(topStructureBci);
            periodicDetection.setTopBsi(topStructureBsi);
            periodicDetection.setBottomBci(bottomBci);
            periodicDetection.setBottomBsi(bottomBsi);
            periodicDetection.setBci(bci);
            periodicDetection.setBsi(bsi);
            periodicDetection.setIntactConditionClass(getAssessClass(bci));
            periodicDetection.setStructureConditionClass(getAssessClass(bsi));
            periodicDetectionMapper.insert(periodicDetection);

            List<BridgeDeckDetectionDto> bridgeDeckDetectionDtoList = periodicDetectionResultDto.getBridgeDeckDetectionDtoList();
            bridgeDeckDetectionDtoList.forEach(detectionDtoList -> {
                detectionDtoList.getBridgeDeckDetectionResults().forEach(detectionResult -> {
                    detectionResult.setPeriodicDetectionDate(LocalDate.now());
                    detectionResult.setBridgeId(bridgeId);
                });
                bridgeDeckDetectionResultService.saveBatch(detectionDtoList.getBridgeDeckDetectionResults());
            });

            saveTopStructureDetectionResults(bridgeId, periodicDetectionResultDto.getTopStructureDetectionDtoList());
            saveBottomStructureDetectionResults(bridgeId, periodicDetectionResultDto.getBottomStructurePierDetectionDtoList());
            saveBottomStructureDetectionResults(bridgeId, periodicDetectionResultDto.getBottomStructureAbutmentDetectionDtoList());
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return RespBean.error("定期检测结果提交失败");
        }
        return RespBean.success("定期检测结果提交成功", periodicDetection);
    }

    private void saveBottomStructureDetectionResults(String bridgeId, List<List<BottomStructureDetectionDto>> bottomStructureDetectionDtoList) {
        for (int i = 0; i < bottomStructureDetectionDtoList.size(); i++) {
            bottomStructureDetectionDtoList.get(i).forEach(detectionDto -> {
                detectionDto.getBottomStructureDetectionResults().forEach(result -> {
                    result.setPeriodicDetectionDate(LocalDate.now());
                    result.setBridgeId(bridgeId);
                });
                bottomStructureDetectionResultService.saveBatch(detectionDto.getBottomStructureDetectionResults());
            });
        }
    }

    /**
     * 保存上部结构检测数据
     * @param bridgeId
     * @param topStructureDetectionDtoList
     */
    private void saveTopStructureDetectionResults(String bridgeId, List<List<TopStructureDetectionDto>> topStructureDetectionDtoList) {
        for (int i = 0; i < topStructureDetectionDtoList.size(); i++) {
            topStructureDetectionDtoList.get(i).forEach(detectionDto -> {
                detectionDto.getTopStructureDetectionResults().forEach(result -> {
                    result.setBridgeId(bridgeId);
                    result.setPeriodicDetectionDate(LocalDate.now());
                });
                topStructureDetectionResultService.saveBatch(detectionDto.getTopStructureDetectionResults());
            });
        }
    }

    /**
     * 根据桥梁id获取桥梁定期检测统计数据
     * @param bridgeId
     * @return
     */
    @Override
    public List<PeriodicDetection> getPeriodicDetectionResultStatistic(String bridgeId) {
        List<PeriodicDetection> resultStatistic = null;
        try {
            resultStatistic = periodicDetectionMapper.selectList(
                    new QueryWrapper<PeriodicDetection>()
                            .eq("bridge_id", bridgeId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultStatistic;
    }

    /**
     * 根据桥梁id获取桥梁定期检测历史记录
     * @param bridgeId
     * @return
     */
    @Override
    public List<PeriodicDetectionResultVo> getPeriodicDetectionResultHistory(String bridgeId) {
        List<PeriodicDetectionResultVo> periodicDetectionResultVos = new ArrayList<>();
        Integer structureId = bridgeInfoMapper.getStructureIdByBridgeId(bridgeId);

        List<DetectionResultInfo> detectionResultInfoList = periodicDetectionMapper.getDetectionResultInfo(bridgeId);

        //桥面系配置项
        List<PeriodicDetectionConf> bridgeDeckConfig = detectionConfMapper.selectList(new QueryWrapper<PeriodicDetectionConf>()
                .eq("structure_id", structureId)
                .isNotNull("bridge_deck_component_id"));
        //上部结构配置项
        List<PeriodicDetectionConf> topStructureConfig = detectionConfMapper.selectList(new QueryWrapper<PeriodicDetectionConf>()
                .eq("structure_id", structureId)
                .isNotNull("top_structure_component_id"));
        //下部结构桥蹲配置项
        List<PeriodicDetectionConf> bottomStructurePierConfig = detectionConfMapper.getBottomStructurePierConfig(structureId);
        //下部结构桥台配置项
        List<PeriodicDetectionConf> bottomStructureAbutmentConfig = detectionConfMapper.getBottomStructureAbutmentConfig(structureId);

        detectionResultInfoList.forEach(resultInfo -> {
            PeriodicDetectionResultVo periodicDetectionResultVo = new PeriodicDetectionResultVo();
            periodicDetectionResultVo.setPeriodicDetectionDate(resultInfo.getPeriodicDetectionDate());
            periodicDetectionResultVo.setUsername(resultInfo.getUsername());
            List<BridgeDeckDetectionComponent> bridgeDeckDetectionComponents = new ArrayList<>();
            bridgeDeckConfig.forEach(bridgeDeck -> {
                BridgeDeckDetectionComponent bridgeDeckDetectionComponent =  periodicDetectionMapper.getBridgeDeckDetectionResult(bridgeDeck.getBridgeDeckComponentId(), resultInfo);
                bridgeDeckDetectionComponents.add(bridgeDeckDetectionComponent);
            });
            periodicDetectionResultVo.setBridgeDeckDetectionComponents(bridgeDeckDetectionComponents);

            List<TopStructureDetectionComponent> topStructureDetectionComponents = new ArrayList<>();
            List<BottomStructureDetectionComponent> bottomStructurePierDetectionComponents = new ArrayList<>();
            List<BottomStructureDetectionComponent> bottomStructureAbutmentDetectionComponents = new ArrayList<>();
            for (int i = 1; i <= resultInfo.getSpanNum(); i++) {
                int spanNum = i;
                topStructureConfig.forEach(topStructure -> {
                    TopStructureDetectionComponent topStructureDetectionComponent = periodicDetectionMapper.getTopStructureDetectionResult(topStructure.getTopStructureComponentId(), spanNum, resultInfo);
                    topStructureDetectionComponent.setTopStructureSpanNum(spanNum);
                    topStructureDetectionComponents.add(topStructureDetectionComponent);
                });

                bottomStructurePierConfig.forEach(bottomStructurePier -> {
                    BottomStructureDetectionComponent bottomStructurePierDetectionComponent = periodicDetectionMapper.getBottomStructureDetectionResult(bottomStructurePier.getBottomStructureComponentId(), spanNum, resultInfo);
                    bottomStructurePierDetectionComponent.setBottomStructureSpanNum(spanNum);
                    bottomStructurePierDetectionComponents.add(bottomStructurePierDetectionComponent);
                });

                bottomStructureAbutmentConfig.forEach(bottomStructureAbutment -> {
                    BottomStructureDetectionComponent bottomStructureAbutmentDetectionComponent = periodicDetectionMapper.getBottomStructureDetectionResult(bottomStructureAbutment.getBottomStructureComponentId(), spanNum, resultInfo);
                    bottomStructureAbutmentDetectionComponent.setBottomStructureSpanNum(spanNum);
                    bottomStructureAbutmentDetectionComponents.add(bottomStructureAbutmentDetectionComponent);
                });
            }
            periodicDetectionResultVo.setTopStructureDetectionComponents(topStructureDetectionComponents);
            periodicDetectionResultVo.setBottomStructurePierDetectionComponents(bottomStructurePierDetectionComponents);
            periodicDetectionResultVo.setBottomStructureAbutmentDetectionComponents(bottomStructureAbutmentDetectionComponents);
            periodicDetectionResultVos.add(periodicDetectionResultVo);
        });

        return periodicDetectionResultVos;
    }

    private String getAssessClass(Integer bci) {
        String cls;
        if (bci < 50) {
            cls = "E";
        } else if (bci < 66) {
            cls = "D";
        } else if (bci < 80) {
            cls = "C";
        } else if (bci < 90) {
            cls = "B";
        } else {
            cls = "A";
        }
        return cls;
    }

    private Integer getBciOrBsi(StructureWeight structureWeight, Integer bridgeDeckBci, Integer topStructureBci, Integer bottomBci) {
        double bci = bridgeDeckBci * structureWeight.getBridgeDeckWeight().doubleValue()
                + topStructureBci * structureWeight.getTopStructureWeight().doubleValue()
                + bottomBci * structureWeight.getBottomStructureWeight().doubleValue();
        return (int) bci;
    }

    private Integer getBottomStructureBsi(List<Integer> bottomBci_si) {
        Integer bsi = bottomBci_si.get(0);
        for (int bci_i: bottomBci_si) {
            if (bci_i < bsi) {
                bsi = bci_i;
            }
        }
        return bsi;
    }

    private Integer getBottomStructureBci(List<Integer> bottomBci_si) {
        Integer bci;
        Integer sum = 0;
        for (int bci_i: bottomBci_si) {
            sum += bci_i;
        }
        bci  = sum / bottomBci_si.size();
        return bci;
    }


    private List<Integer> getBottomStructureBci_si(List<List<BottomStructureDetectionDto>> bottomStructurePierDetectionDtoList) {
        List<Integer> bci_si = new ArrayList<>();
        for (List<BottomStructureDetectionDto> detectionDtoList: bottomStructurePierDetectionDtoList) {
            Integer bci_sij = getBottomStructureBci_sij(detectionDtoList);
            bci_si.add(bci_sij);
        }
        return bci_si;
    }

    private Integer getBottomStructureBci_sij(List<BottomStructureDetectionDto> detectionDtoList) {
        List<Integer> sdp_jk = new ArrayList<>();
        for (BottomStructureDetectionDto detectionDto: detectionDtoList) {
            Integer sdp_jkl = getBottomStructureSdp_jkl(detectionDto.getBottomStructureDetectionResults());
            sdp_jk.add(sdp_jkl);
        }
        double bci_sij = 0;
        for (int i = 0; i < sdp_jk.size(); i++) {
            bci_sij += (100 - sdp_jk.get(i)) * detectionDtoList.get(i).getWeight();
        }
        return (int) bci_sij;
    }

    private Integer getBottomStructureSdp_jkl(List<BottomStructureDetectionResult> bottomStructureDetectionResults) {
        Integer sumDp_jkl = sumBottomStructureDp_jkl(bottomStructureDetectionResults);
        double sdp_jkl = 0;
        for (BottomStructureDetectionResult result: bottomStructureDetectionResults) {
            double w_jkl = getWeight_i(result.getBottomStructureDeduction(), sumDp_jkl);
            sdp_jkl += result.getBottomStructureDeduction() * w_jkl;
        }
        sdp_jkl = sdp_jkl > 100 ? 100 : sdp_jkl;
        return (int) sdp_jkl;
    }

    private Integer sumBottomStructureDp_jkl(List<BottomStructureDetectionResult> bottomStructureDetectionResults) {
        Integer sumDp_jkl = 0;
        for (BottomStructureDetectionResult result: bottomStructureDetectionResults) {
            sumDp_jkl += result.getBottomStructureDeduction();
        }
        return sumDp_jkl;
    }

    /**
     * 求TopStructureBci
     * @param bci_si
     * @return
     */
    private Integer getTopStructureBci(List<Integer> bci_si) {
        Integer bci;
        Integer sum = 0;
        for (Integer bci_i: bci_si) {
            sum += bci_i;
        }
        bci = sum / bci_si.size();
        return bci;
    }

    /**
     * 求TopStructureBsi
     * @param bci_si
     * @return
     */
    private Integer getTopStructureBsi(List<Integer> bci_si) {
        Integer minBsi = bci_si.get(0);
        for (Integer bci_i: bci_si) {
            if (bci_i < minBsi) {
                minBsi = bci_i;
            }
        }
        return minBsi;
    }

    /**
     * 求bci_si
     * @param topStructureDetectionDtoList
     * @return
     */
    private List<Integer> getTopStructureBci_si(List<List<TopStructureDetectionDto>> topStructureDetectionDtoList) {
        List<Integer> bci_si = new ArrayList<>();
        for (List<TopStructureDetectionDto> detectionDtoList: topStructureDetectionDtoList) {
            Integer bci_sij = getTopStructureBci_sij(detectionDtoList);
            bci_si.add(bci_sij);
        }
        return bci_si;
    }

    /**
     * 求bci_sij
     * @param detectionDtoList
     * @return
     */
    private Integer getTopStructureBci_sij(List<TopStructureDetectionDto> detectionDtoList) {
        List<Integer> sdp_jk = new ArrayList<>();
        for (TopStructureDetectionDto detectionDto: detectionDtoList) {
            Integer sdp_jkl = getTopStructureSdp_jkl(detectionDto.getTopStructureDetectionResults());
            sdp_jk.add(sdp_jkl);
        }
        double bci_sij = 0;
        for (int i = 0; i < sdp_jk.size(); i++) {
            bci_sij += (100 - sdp_jk.get(i)) * detectionDtoList.get(i).getWeight();
        }
        return (int) bci_sij;
    }

    /**
     * 求TopStructureSdp_jkl
     * @param topStructureDetectionResults
     * @return
     */
    private Integer getTopStructureSdp_jkl(List<TopStructureDetectionResult> topStructureDetectionResults) {
        Integer sumDp_jkl = sumTopStructureDp_jkl(topStructureDetectionResults);
        double sdp_jkl = 0;
        for (TopStructureDetectionResult result: topStructureDetectionResults) {
            double w_jkl = getWeight_i(result.getTopStructureDeduction(), sumDp_jkl);
            sdp_jkl += result.getTopStructureDeduction() * w_jkl;
        }
        sdp_jkl = sdp_jkl > 100 ? 100 : sdp_jkl;
        return (int) sdp_jkl;
    }

    /**
     * 求TopStructureDp_jkl
     * @param topStructureDetectionResults
     * @return
     */
    private Integer sumTopStructureDp_jkl(List<TopStructureDetectionResult> topStructureDetectionResults) {
        Integer sumDp_jkl = 0;
        for (TopStructureDetectionResult result: topStructureDetectionResults) {
            sumDp_jkl += result.getTopStructureDeduction();
        }
        return sumDp_jkl;
    }

    /**
     * 求BridgeDeckBci
     * @param mdp_h
     * @param bridgeDeckDetectionDtoList
     * @return
     */
    private Integer getBridgeDeckBci(List<Integer> mdp_h, List<BridgeDeckDetectionDto> bridgeDeckDetectionDtoList) {
        double bci = 0;
        for (int i = 0; i < bridgeDeckDetectionDtoList.size(); i++) {
            bci += (100 - mdp_h.get(i)) * bridgeDeckDetectionDtoList.get(i).getWeight();
        }
        return (int) bci;
    }

    /**
     * 求BridgeDeckBsi
     * @param mdp_h
     * @return
     */
    private Integer getBridgeDeckBsi(List<Integer> mdp_h) {
        int bsi = (100 - mdp_h.get(0));
        for (Integer mdp: mdp_h) {
            if ((100 - mdp) < bsi) {
                bsi = (100 - mdp);
            }
        }
        return bsi;
    }

    /**
     * 求bridgeDeckMdp_h
     * @param bridgeDeckDetectionDtoList
     * @return
     */
    private List<Integer> getBridgeDeckMdp_h(List<BridgeDeckDetectionDto> bridgeDeckDetectionDtoList) {
        List<Integer> mdp_h = new ArrayList<>();
        for (BridgeDeckDetectionDto detectionDto: bridgeDeckDetectionDtoList) {
            Integer mdp = getBridgeDeckMdp(detectionDto.getBridgeDeckDetectionResults());
            mdp_h.add(mdp);
        }
        return mdp_h;
    }

    /**
     * 求BridgeDeckMdp
     * @param bridgeDeckDetectionResults
     * @return
     */
    private Integer getBridgeDeckMdp(List<BridgeDeckDetectionResult> bridgeDeckDetectionResults) {
        double mdp = 0;
        Integer sumDp_hi = sumDp_hi(bridgeDeckDetectionResults);
        for (BridgeDeckDetectionResult result: bridgeDeckDetectionResults) {
            double w_hi = getWeight_i(result.getBridgeDeckDeduction(), sumDp_hi);
            mdp += result.getBridgeDeckDeduction() * w_hi;
        }
        mdp = mdp > 100 ? 100 : mdp;
        return (int) mdp;
    }

    /**
     * sum dp_hi
     * @param bridgeDeckDetectionResults
     * @return
     */
    private Integer sumDp_hi(List<BridgeDeckDetectionResult> bridgeDeckDetectionResults) {
        Integer sum = 0;
        for (BridgeDeckDetectionResult result: bridgeDeckDetectionResults) {
            sum += result.getBridgeDeckDeduction();
        }
        return sum;
    }

    /**
     * 求权重
     * @param dp_i
     * @param dpSum
     * @return
     */
    private double getWeight_i(int dp_i, int dpSum) {
        double weight_i = 0;
        try {
            double mu_i = 0;
            if (dpSum != 0) {
                mu_i = dp_i / dpSum;
            }
            weight_i = 3.0 * Math.pow(mu_i, 3) - 5.5 * Math.pow(mu_i, 2) + 3.5 * mu_i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weight_i;
    }
}
