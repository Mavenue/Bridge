package com.bridge.sys.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bridge.common.utils.RespBean;
import com.bridge.sys.pojo.dto.RoutineDetectionResultsDto;
import com.bridge.sys.service.IRoutineDetectionResultService;
import com.bridge.sys.service.IRoutineDetectionService;
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
@RequestMapping("/routine-detection-result")
public class RoutineDetectionResultController {

    @Autowired
    private IRoutineDetectionResultService routineDetectionResultServiceService;

    @ApiOperation(value = "日常检查表单提交")
    @PostMapping(value = "/result")
    public RespBean insertRoutineDetectionResults(@RequestBody RoutineDetectionResultsDto routineDetectionResultsDto, Principal principal) {
        return routineDetectionResultServiceService.insertRoutineDetectionResults(routineDetectionResultsDto, principal);
    }
}
