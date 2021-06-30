package com.bridge.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.BridgeInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.security.Principal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
public interface IBridgeInfoService extends IService<BridgeInfo> {

    /**
     * 根据桥梁id查询桥梁信息
     * @param bridgeId
     * @return
     */
    BridgeInfo getBridgeInfoById(String bridgeId);

    /**
     * 建立桥梁资料卡
     * @param bridgeInfo
     * @param principal
     * @return
     */
    RespBean submitBridgeInfo(BridgeInfo bridgeInfo, Principal principal);


    /**
     * 分页获取所有桥梁资料卡信息
     * @param current
     * @param size
     * @param bridgeName
     * @return
     */
    Page<BridgeInfo> getAllBridgeInfo(long current, long size, String bridgeName);
}
