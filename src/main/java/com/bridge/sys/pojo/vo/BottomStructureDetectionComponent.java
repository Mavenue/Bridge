package com.bridge.sys.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@Accessors(chain = true)
@ApiModel(value = "BottomStructureDetectionComponent对象")
public class BottomStructureDetectionComponent {

    @ApiModelProperty(value = "下部部结构构件类型名")
    private String bottomStructureComponentName;

    @ApiModelProperty(value = "下部结构构件类型id")
    private String bottomStructureComponentId;

    @ApiModelProperty(value = "第几跨")
    private Integer bottomStructureSpanNum;

    @ApiModelProperty(value = "上部结构构件对应的损坏类型检测结果集")
    List<BottomStructureDetectionResultVo> bottomStructureDetectionResultVos;
}
