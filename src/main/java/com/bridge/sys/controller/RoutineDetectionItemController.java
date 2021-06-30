package com.bridge.sys.controller;


import com.bridge.sys.pojo.RoutineDetectionItem;
import com.bridge.sys.service.IRoutineDetectionItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/routine-detection-item")
public class RoutineDetectionItemController {
    @Autowired
    private IRoutineDetectionItemService routineDetectionItemService;

    @ApiOperation(value = "获取桥梁所有日常检测项")
    @GetMapping(value = "/all-items")
    public List<RoutineDetectionItem> getAllRoutineDetectionItems() {
        return routineDetectionItemService.getAllRoutineDetectionItems();
    }
}
