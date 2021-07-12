package com.bridge.sys.mapper;

import com.bridge.sys.pojo.BridgeDeckDamageType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bridge.sys.pojo.vo.BridgeDeckDamageTypeVo;
import com.bridge.sys.pojo.vo.BridgeDeckDetectionVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface BridgeDeckDamageTypeMapper extends BaseMapper<BridgeDeckDamageType> {

    /**
     * 根据桥面系构件类型id获取桥面系损坏类型视图对象集合
     * @param bridgeDeckComponentId
     * @return
     */
    List<BridgeDeckDamageTypeVo> getBridgeDeckDamageTypeVos(String bridgeDeckComponentId);
}
