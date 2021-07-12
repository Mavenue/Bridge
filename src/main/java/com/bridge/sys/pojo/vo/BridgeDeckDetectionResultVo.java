package com.bridge.sys.pojo.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "BridgeDeckDetectionResultVo对象")
public class BridgeDeckDetectionResultVo {

    @ApiModelProperty(value = "桥面系损坏类型名")
    private String bridgeDeckDamageTypeName;

    @ApiModelProperty(value = "扣分值")
    private Integer bridgeDeckDeduction;
}
