package com.bridge.sys.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "RoutineDetectionHistoryVo对象", description = "日常检测历史记录视图对象")
public class RoutineDetectionHistoryVo {
    @ApiModelProperty("历史检测时间")
    private String routineDetectionDate;

    @ApiModelProperty(value = "制表人")
    private String username;

    @ApiModelProperty(value = "历史日常监测项结果视图集")
    private List<RoutineDetectionHistoryResultsVo> historyResultsVos;
}
