package com.bridge.sys.pojo.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "BottomStructureDamageClassVo对象")
public class BottomStructureDamageClassVo {

    @ApiModelProperty(value = "下部结构损坏类型等级")
    private String bottomStructureDamageClassName;

    @ApiModelProperty(value = "下部结构损坏等级对应的扣分值")
    private Integer bottomStructureClassDeduction;
}
