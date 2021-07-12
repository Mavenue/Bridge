package com.bridge.sys.pojo.vo;

import com.bridge.sys.pojo.BottomComponentType;
import com.bridge.sys.pojo.BottomStructureDamageType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "BottomStructureDetectionVo对象")
public class BottomStructureDetectionVo {

    @ApiModelProperty(value = "下部构件类型名")
    private String bottomStructureComponentName;

    @ApiModelProperty(value = "下部构件权重")
    private Double weight;

    @ApiModelProperty(value = "下部构件对应的损坏类型")
    private List<BottomStructureDamageTypeVo> bottomStructureDamageTypeVos;
}
