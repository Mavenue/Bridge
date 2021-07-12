package com.bridge.sys.mapper;

import com.bridge.sys.pojo.PeriodicDetection;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bridge.sys.pojo.vo.BottomStructureDetectionComponent;
import com.bridge.sys.pojo.vo.BridgeDeckDetectionComponent;
import com.bridge.sys.pojo.vo.DetectionResultInfo;
import com.bridge.sys.pojo.vo.TopStructureDetectionComponent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface PeriodicDetectionMapper extends BaseMapper<PeriodicDetection> {

    /**
     * 根据桥梁id获取桥梁定期检测历史记录
     * @param bridgeId
     * @return
     */
    List<DetectionResultInfo> getDetectionResultInfo(String bridgeId);

    /**
     * 根据桥面系构件类型和桥梁编号 检测日期查询日常检测记录
     * @param bridgeDeckComponentId
     * @param resultInfo
     * @return
     */
    BridgeDeckDetectionComponent getBridgeDeckDetectionResult(@Param("bridgeDeckComponentId") String bridgeDeckComponentId, @Param("resultInfo") DetectionResultInfo resultInfo);

    /**
     * 据上部结构构件类型和桥梁编号 检测日期查询日常检测记录
     * @param topStructureComponentId
     * @param spanNum
     * @param resultInfo
     * @return
     */
    TopStructureDetectionComponent getTopStructureDetectionResult(@Param("topStructureComponentId") String topStructureComponentId, @Param("spanNum") int spanNum, @Param("resultInfo") DetectionResultInfo resultInfo);

    /**
     * 据下部结构构件类型和桥梁编号 检测日期查询日常检测记录
     * @param bottomStructureComponentId
     * @param spanNum
     * @param resultInfo
     * @return
     */
    BottomStructureDetectionComponent getBottomStructureDetectionResult(@Param("bottomStructureComponentId") String bottomStructureComponentId, @Param("spanNum") int spanNum, @Param("resultInfo")DetectionResultInfo resultInfo);
}
