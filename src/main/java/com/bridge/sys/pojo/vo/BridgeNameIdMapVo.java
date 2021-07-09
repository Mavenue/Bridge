package com.bridge.sys.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BridgeNameIdMapVo {
    @ApiModelProperty(value = "桥梁名称")
    private String bridgeName;

    @ApiModelProperty(value = "桥梁id")
    private String bridgeId;
}
