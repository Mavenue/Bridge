package com.bridge.sys.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.BridgeInfo;
import com.bridge.sys.pojo.vo.BridgeNameIdMapVo;
import com.bridge.sys.service.IBridgeInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
@RestController
@RequestMapping("/bridge-info")
public class BridgeInfoController {

    @Autowired
    private IBridgeInfoService bridgeInfoService;

    @ApiOperation(value = "分页获取所有桥梁资料卡信息")
    @GetMapping(value = "/all-info")
    public Page<BridgeInfo> getAllBridgeInfo(long current, long size, String bridgeName) {
        return bridgeInfoService.getAllBridgeInfo(current, size, bridgeName);
    }

    @ApiOperation(value = "通过桥梁id查询桥梁信息")
    @GetMapping(value = "/{bridgeId}")
    public BridgeInfo getBridgeInfoById(@PathVariable String bridgeId) {
        return bridgeInfoService.getBridgeInfoById(bridgeId);
    }

    @ApiOperation(value = "建立桥梁资料卡")
    @PostMapping()
    public RespBean submitBridgeInfo(@RequestBody BridgeInfo bridgeInfo, Principal principal) {
        return bridgeInfoService.submitBridgeInfo(bridgeInfo, principal);
    }

    @ApiOperation(value = "获取桥梁名称id键值对")
    @GetMapping(value = "/bridge-name-id-map")
    public List<BridgeNameIdMapVo> getBridgeNameIdMap() {
        return bridgeInfoService.getBridgeNameIdMap();
    }

    @ApiOperation(value = "根据桥梁名称模糊查询桥梁id")
    @GetMapping(value = "/vague-name-id/{bridgeName}")
    public List<BridgeNameIdMapVo> getVagueBridgeNameIdMap(@PathVariable String bridgeName) {
        return bridgeInfoService.getVagueBridgeNameIdMap(bridgeName);
    }

    @ApiOperation(value = "根据桥梁id逻辑启用或弃用桥梁资料卡")
    @DeleteMapping(value = "/{bridgeId}")
    public RespBean deleteOrRecoverBridgeInfo(@PathVariable String bridgeId, Principal principal) {
        return bridgeInfoService.deleteOrRecoverBridgeInfo(bridgeId, principal);
    }

    @ApiOperation(value = "修改桥梁资料卡")
    @PutMapping(value = "/update")
    public RespBean updateBridgeInfo(@RequestBody BridgeInfo bridgeInfo, Principal principal) {
        return bridgeInfoService.updateBridgeInfo(bridgeInfo, principal);
    }
}
