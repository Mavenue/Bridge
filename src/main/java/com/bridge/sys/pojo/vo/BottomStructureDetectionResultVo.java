package com.bridge.sys.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "BottomStructureDetectionResultVo对象")
public class BottomStructureDetectionResultVo {

    @ApiModelProperty(value = "下部结构损坏类型名")
    private String bottomStructureDamageTypeName;

    @ApiModelProperty(value = "扣分值")
    private Integer bottomStructureDeduction;
}
