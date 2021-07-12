package com.bridge.sys.pojo.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "BridgeDeckDetectionComponent对象")
public class BridgeDeckDetectionComponent {

    @ApiModelProperty(value = "桥面系结构构件类型id")
    private String bridgeDeckComponentId;

    @ApiModelProperty(value = "桥面系结构构件类型名")
    private String bridgeDeckComponentName;

    @ApiModelProperty(value = "桥面系构件对应的损坏类型检测结果集")
    List<BridgeDeckDetectionResultVo> bridgeDeckDetectionResultVos;
}
