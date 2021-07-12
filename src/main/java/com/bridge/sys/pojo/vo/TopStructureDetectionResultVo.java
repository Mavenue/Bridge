package com.bridge.sys.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "TopStructureDetectionResultVo对象")
public class TopStructureDetectionResultVo {

    @ApiModelProperty(value = "上部结构损坏类型名")
    private String topStructureDamageTypeName;

    @ApiModelProperty(value = "扣分值")
    private Integer topStructureDeduction;
}
