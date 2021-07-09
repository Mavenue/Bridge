package com.bridge.sys.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "PeriodicDetectionVo对象")
public class PeriodicDetectionVo {
    @ApiModelProperty(value = "桥梁敦或跨数")
    private Integer spanNum;

    @ApiModelProperty(value = "桥面系检测内容")
    private List<BridgeDeckDetectionVo> bridgeDeckDetectionVos;

    @ApiModelProperty(value = "上部结构检测内容")
    private List<TopStructureDetectionVo> topStructureDetectionVos;

    @ApiModelProperty(value = "下部结构检测内容")
    private List<BottomStructureDetectionVo> bottomStructureDetectionVos;
}
