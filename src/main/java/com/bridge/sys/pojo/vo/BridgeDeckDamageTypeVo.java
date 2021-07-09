package com.bridge.sys.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "BridgeDeckDamageTypeVo对象")
public class BridgeDeckDamageTypeVo {
    @ApiModelProperty(value = "下部结构损坏类型id")
    private Integer bottomStructureDamageTypeId;

    @ApiModelProperty(value = "下部结构损坏类型名")
    private String bottomStructureDamageTypeName;

    @ApiModelProperty(value = "下部结构损坏类型说明")
    private String bottomStructureDamageTypeExplanation;

    @ApiModelProperty(value = "下部结构损坏类型对应的等级")
    private List<BridgeDeckDamageClassVo> bridgeDeckDamageClassVos;
}
