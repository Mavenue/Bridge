package com.bridge.sys.pojo.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "TopStructureDamageTypeVo对象")
public class TopStructureDamageTypeVo {

    @ApiModelProperty(value = "上部构件类型id")
    private String topStructureComponentId;

    @ApiModelProperty(value = "上部结构损坏类型名")
    private String topStructureDamageTypeName;

    @ApiModelProperty(value = "上部结构损坏类型说明")
    private String topStructureDamageTypeExplanation;

    @ApiModelProperty(value = "上部结构损坏类型对应的等级")
    private List<TopStructureDamageClassVo> topStructureDamageClassVoList;
}
