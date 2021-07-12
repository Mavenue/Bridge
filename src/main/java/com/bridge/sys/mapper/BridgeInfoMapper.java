package com.bridge.sys.mapper;

import com.bridge.sys.pojo.BridgeInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bridge.sys.pojo.vo.BridgeNameIdMapVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface BridgeInfoMapper extends BaseMapper<BridgeInfo> {

    /**
     * 获取桥梁名称id键值对
     * @return
     */
    List<BridgeNameIdMapVo> getBridgeNameIdMap();

    /**
     * 根据桥梁名称模糊查询桥梁id
     * @param bridgeName
     * @return
     */
    List<BridgeNameIdMapVo> getVagueBridgeNameIdMap(String bridgeName);

    /**
     * 根据桥梁id获取桥梁跨数
     * @param bridgeId
     * @return
     */
    Integer getBridgeSpanNumById(String bridgeId);

    /**
     * 根据桥梁id获取桥梁结构类型id
     * @param bridgeId
     * @return
     */
    Integer getStructureIdByBridgeId(String bridgeId);

    /**
     * 启用桥梁资料卡
     * @param bridgeId
     * @return
     */
    int recoverBridgeInfo(String bridgeId);

    /**
     * 弃用桥梁资料卡
     * @param bridgeId
     * @return
     */
    int deleteBridgeInfoLogical(String bridgeId);
}
