package com.bridge.sys.pojo.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "BottomStructureDamageTypeVo对象")
public class BottomStructureDamageTypeVo {

    @ApiModelProperty(value = "下部结构类型id")
    private String bottomStructureDamageTypeId;

    @ApiModelProperty(value = "下部结构损坏类型名")
    private String bottomStructureDamageTypeName;

    @ApiModelProperty(value = "下部结构损坏类型说明")
    private String bottomStructureDamageTypeExplanation;

    @ApiModelProperty(value = "下部结构损坏类型对应的等级")
    private List<BottomStructureDamageClassVo> bottomStructureDamageClassVos;
}
