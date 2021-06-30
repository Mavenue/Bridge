package com.bridge.sys.controller;


import com.bridge.sys.pojo.StructureType;
import com.bridge.sys.service.IStructureTypeService;
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
@RequestMapping("/structure-type")
public class StructureTypeController {

    @Autowired
    private IStructureTypeService structureTypeService;

    @ApiOperation(value = "获取所有桥梁结构类型")
    @GetMapping(value = "/all-types")
    public List<StructureType> getAllBridgeStructureTypes() {
        return structureTypeService.getAllBridgeStructureTypes();
    }
}
