package com.bridge.sys.pojo.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "PeriodicDetectionResultVo对象")
public class PeriodicDetectionResultVo {
    @ApiModelProperty(value = "定期检测日期")
    private LocalDate periodicDetectionDate;

    @ApiModelProperty(value = "定期检测人")
    private String username;

    @ApiModelProperty(value = "桥面系构件的检测结果集")
    private List<BridgeDeckDetectionComponent> bridgeDeckDetectionComponents;

    @ApiModelProperty(value = "上部结构构件的检测结果集")
    private List<TopStructureDetectionComponent> topStructureDetectionComponents;

    @ApiModelProperty(value = "下部结构桥墩检测结果集")
    private List<BottomStructureDetectionComponent> bottomStructurePierDetectionComponents;

    @ApiModelProperty(value = "下部结构桥台检测结果集")
    private List<BottomStructureDetectionComponent> bottomStructureAbutmentDetectionComponents;

}
