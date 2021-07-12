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
    @ApiModelProperty(value = "桥面系损坏类型id")
    private Integer bridgeDeckDamageTypeId;

    @ApiModelProperty(value = "桥面系损坏类型名")
    private String bridgeDeckDamageTypeName;

    @ApiModelProperty(value = "桥面系损坏类型说明")
    private String bridgeDeckDamageTypeExplanation;

    @ApiModelProperty(value = "桥面系损坏类型对应的等级")
    private List<BridgeDeckDamageClassVo> bridgeDeckDamageClassVos;
}
