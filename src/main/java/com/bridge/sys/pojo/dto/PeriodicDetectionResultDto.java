package com.bridge.sys.pojo.dto;


import com.bridge.sys.pojo.BottomStructureDetectionResult;
import com.bridge.sys.pojo.BridgeDeckDetectionResult;
import com.bridge.sys.pojo.TopStructureDetectionResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "PeriodicDetectionResultDto")
public class PeriodicDetectionResultDto {

    @ApiModelProperty(value = "桥梁id", required = true)
    private String bridgeId;

    @ApiModelProperty(value = "定期检测日期")
    private LocalDate periodicDetectionDate;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "桥面系检测结果", required = true)
    private List<BridgeDeckDetectionDto> bridgeDeckDetectionDtoList;

    @ApiModelProperty(value = "上部结构检测结果", required = true)
    private List<List<TopStructureDetectionDto>> topStructureDetectionDtoList;

    @ApiModelProperty(value = "下部结构桥墩检测结果", required = true)
    private List<List<BottomStructureDetectionDto>> bottomStructurePierDetectionDtoList;

    @ApiModelProperty(value = "下部结构桥台检测结果", required = true)
    private List<List<BottomStructureDetectionDto>> bottomStructureAbutmentDetectionDtoList;
}
