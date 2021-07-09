package com.bridge.sys.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "TopStructureDamageClassVo对象")
public class TopStructureDamageClassVo {

    @ApiModelProperty(value = "上部结构损坏类型等级")
    private String topStructureDamageClassName;

    @ApiModelProperty(value = "上部结构损坏类型对应的扣分值")
    private Integer topStructureClassDeduction;
}
