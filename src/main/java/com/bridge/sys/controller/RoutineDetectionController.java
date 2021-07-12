package com.bridge.sys.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.RoutineDetectionItem;
import com.bridge.sys.pojo.dto.RoutineDetectionResultsDto;
import com.bridge.sys.pojo.vo.RoutineDetectionHistoryVo;
import com.bridge.sys.service.IRoutineDetectionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/routine-detection")
public class RoutineDetectionController {

    @Autowired
    private IRoutineDetectionService routineDetectionService;

    @ApiOperation(value = "根据桥梁id分页获取该桥梁的所有日常监测记录信息")
    @GetMapping(value = "/history/{bridgeId}")
    public List<RoutineDetectionHistoryVo> getRoutineDetectionHistoryByBridgeId(@PathVariable String bridgeId) {
        return routineDetectionService.getRoutineDetectionHistoryByBridgeId(bridgeId);
    }
}
