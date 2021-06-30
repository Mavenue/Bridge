package com.bridge.sys.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.BridgeInfo;
import com.bridge.sys.service.IBridgeInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
    @GetMapping(value = "/all-info/{current}/{size}/{bridgeName}")
    public Page<BridgeInfo> getAllBridgeInfo(@PathVariable long current, @PathVariable long size, @PathVariable String bridgeName) {
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

}
