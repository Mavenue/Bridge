package com.bridge.sys.service.impl;

import com.bridge.common.utils.RespBean;
import com.bridge.sys.mapper.PeriodicDetectionConfMapper;
import com.bridge.sys.pojo.BridgeDeckDetectionResult;
import com.bridge.sys.pojo.PeriodicDetection;
import com.bridge.sys.mapper.PeriodicDetectionMapper;
import com.bridge.sys.pojo.TopStructureDetectionResult;
import com.bridge.sys.pojo.dto.PeriodicDetectionResultDto;
import com.bridge.sys.service.IPeriodicDetectionConfService;
import com.bridge.sys.service.IPeriodicDetectionService;
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
public class PeriodicDetectionServiceImpl extends ServiceImpl<PeriodicDetectionMapper, PeriodicDetection> implements IPeriodicDetectionService {

    @Autowired
    private PeriodicDetectionConfMapper detectionConfMapper;

    /**
     * 定期检测结果提交
     * @param periodicDetectionResultDto
     * @return
     */
    @Override
    public RespBean submitPeriodicDetectionResults(PeriodicDetectionResultDto periodicDetectionResultDto) {
        Integer bridgeDeckBci = getBridgeDeckBci(periodicDetectionResultDto.getBridgeDeckDetectionResults());
        Integer bridgeDeckBsi = getBridgeDeckBsi(periodicDetectionResultDto.getBridgeDeckDetectionResults());
        Integer topStructureBci = getTopStructureBci(periodicDetectionResultDto.getTopStructureDetectionResults());
        Integer topStructureBsi = getTopStructureBsi(periodicDetectionResultDto.getTopStructureDetectionResults());
        return null;
    }

    /**
     * 求上部结构bsi
     * @param topStructureDetectionResults
     * @return
     */
    private Integer getTopStructureBsi(List<List<TopStructureDetectionResult>> topStructureDetectionResults) {
        return null;
    }

    /**
     * 求上部结构bci
     * @param topStructureDetectionResults
     * @return
     */
    private Integer getTopStructureBci(List<List<TopStructureDetectionResult>> topStructureDetectionResults) {
        return null;
    }

    /**
     * 求桥面系bsi
     * @param bridgeDeckDetectionResults
     * @return
     */
    private Integer getBridgeDeckBsi(List<BridgeDeckDetectionResult> bridgeDeckDetectionResults) {
        int dpSum = sumBridgeDeckDp(bridgeDeckDetectionResults);
        int mdp = calBridgeDeckMdp(bridgeDeckDetectionResults, dpSum);
        int bsi  = mdp > 100 ? 100 : mdp;
        return bsi;
    }

    /**
     * 求桥面系mdp
     * @param bridgeDeckDetectionResults
     * @param dpSum
     * @return
     */
    private int calBridgeDeckMdp(List<BridgeDeckDetectionResult> bridgeDeckDetectionResults, int dpSum) {
        double mdp = 0;
        for (int i = 0; i < bridgeDeckDetectionResults.size(); i++) {
            double whi = getBridgeDeckW_hi(dpSum, bridgeDeckDetectionResults.get(i).getBridgeDeckDeduction());
            mdp += bridgeDeckDetectionResults.get(i).getBridgeDeckDeduction() * whi;
        }
        return (int) mdp;
    }

    /**
     * 求桥面系w_hi
     * @param dpSum
     * @param bridgeDeckDeduction
     * @return
     */
    private double getBridgeDeckW_hi(int dpSum, Integer bridgeDeckDeduction) {
        double w_hi = 0;
        try {
            double mu_hi = bridgeDeckDeduction / dpSum;
            w_hi = 3.0 * Math.pow(mu_hi, 3) - 5.5 * Math.pow(mu_hi, 2) + 3.5 * mu_hi;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return w_hi;
    }

    /**
     * 求桥面系DP的总和
     * @param bridgeDeckDetectionResults
     * @return
     */
    private int sumBridgeDeckDp(List<BridgeDeckDetectionResult> bridgeDeckDetectionResults) {
        int sum = 0;
        for (int i = 0; i < bridgeDeckDetectionResults.size(); i++) {
            sum += bridgeDeckDetectionResults.get(i).getBridgeDeckDeduction();
        }
        return sum;
    }

    /**
     * 求桥面系bci
     * @param bridgeDeckDetectionResults
     * @return
     */
    private Integer getBridgeDeckBci(List<BridgeDeckDetectionResult> bridgeDeckDetectionResults) {
        int dpSum = sumBridgeDeckDp(bridgeDeckDetectionResults);
        int mdp = calBridgeDeckMdp(bridgeDeckDetectionResults, dpSum);
        double bci = 0;
        for (int i = 0; i < bridgeDeckDetectionResults.size(); i++) {
            bci += (100 - mdp) * bridgeDeckDetectionResults.get(i).getWeight();
        }
        return (int) bci;
    }

}
