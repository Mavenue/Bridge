package com.bridge.sys.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UpdateAuthUserDto", description="")
public class UpdateAuthUserDto {
    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "修改后的用户权限", required = true)
    private Integer type;
}
