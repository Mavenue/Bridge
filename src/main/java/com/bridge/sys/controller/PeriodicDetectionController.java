package com.bridge.sys.controller;


import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.PeriodicDetection;
import com.bridge.sys.pojo.dto.PeriodicDetectionResultDto;
import com.bridge.sys.pojo.vo.PeriodicDetectionResultVo;
import com.bridge.sys.service.IPeriodicDetectionService;
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
@RequestMapping("/periodic-detection")
public class PeriodicDetectionController {

    @Autowired
    private IPeriodicDetectionService periodicDetectionService;

    @ApiOperation(value = "定期检测结果提交")
    @PostMapping(value = "/results")
    public RespBean submitPeriodicDetectionResults(@RequestBody PeriodicDetectionResultDto periodicDetectionResultDto, Principal principal) {
        return periodicDetectionService.submitPeriodicDetectionResults(periodicDetectionResultDto, principal);
    }

    @ApiOperation(value = "根据桥梁id获取桥梁定期检测统计数据")
    @GetMapping(value = "/{bridgeId}")
    public List<PeriodicDetection> getPeriodicDetectionResultStatistic(@PathVariable String bridgeId) {
        return periodicDetectionService.getPeriodicDetectionResultStatistic(bridgeId);
    }

    @ApiOperation(value = "根据桥梁id获取桥梁定期检测历史记录")
    @GetMapping(value = "/info/{bridgeId}")
    public List<PeriodicDetectionResultVo> getPeriodicDetectionResultHistory(@PathVariable String bridgeId) {
        return periodicDetectionService.getPeriodicDetectionResultHistory(bridgeId);
    }
}
