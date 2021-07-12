package com.bridge.sys.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "Router对象")
public class Router {

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "component")
    private String component;

    @ApiModelProperty(value = "icon")
    private String icon;

    @ApiModelProperty(value = "path")
    private String path;

    @ApiModelProperty(value = "title")
    private String title;

    @ApiModelProperty(value = "children")
    private List<Router> children;
}
