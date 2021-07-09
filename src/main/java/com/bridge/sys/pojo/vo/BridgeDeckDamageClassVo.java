package com.bridge.sys.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "BridgeDeckDamageClassVo对象")
public class BridgeDeckDamageClassVo {
    @ApiModelProperty(value = "桥面系损坏类型等级")
    private String bridgeDeckDamageClassName;

    @ApiModelProperty(value = "桥面系损坏类型等级对应扣分值")
    private Integer bridgeDeckClassDeduction;
}
