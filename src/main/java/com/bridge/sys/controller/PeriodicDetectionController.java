package com.bridge.sys.controller;


import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.dto.PeriodicDetectionResultDto;
import com.bridge.sys.service.IPeriodicDetectionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
    public RespBean submitPeriodicDetectionResults(@RequestBody PeriodicDetectionResultDto periodicDetectionResultDto) {
        return periodicDetectionService.submitPeriodicDetectionResults(periodicDetectionResultDto);
    }
}
