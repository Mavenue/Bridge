package com.bridge.sys.controller;


import com.bridge.sys.pojo.vo.PeriodicDetectionVo;
import com.bridge.sys.service.IPeriodicDetectionConfService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/periodic-detection-conf")
public class PeriodicDetectionConfController {
    @Autowired
    private IPeriodicDetectionConfService periodicDetectionConfService;

    @ApiOperation(value = "根据桥梁id获取桥梁定期检测内容")
    @GetMapping(value = "/{bridgeId}")
    public PeriodicDetectionVo getPeriodicDetectionContents(@PathVariable String bridgeId) {
        return periodicDetectionConfService.getPeriodicDetectionContents(bridgeId);
    }
}
