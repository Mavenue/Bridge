package com.bridge.sys.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "RoutineDetectionHistoryVo对象", description = "历史日常监测项结果视图对象")
public class RoutineDetectionHistoryResultsVo {
    @ApiModelProperty(value = "检测项名称")
    private String detectionItem;

    @ApiModelProperty(value = "是否完好", required = true)
    private String isCompletion;

    @ApiModelProperty(value = "损坏类型")
    private String damageType;

    @ApiModelProperty(value = "损坏程度")
    private String damageDegree;

    @ApiModelProperty(value = "损坏位置")
    private String damageLocation;

    @ApiModelProperty(value = "备注")
    private String remark;
}
