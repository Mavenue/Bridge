package com.bridge.sys.pojo;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author mavenue
 * @since 2021-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BottomStructureDamageType对象", description="")
public class BottomStructureDamageType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "下部结构损坏类型id")
    private Integer bottomStructureDamageTypeId;

    @ApiModelProperty(value = "下部构件类型id")
    private String bottomStructureComponentId;

    @ApiModelProperty(value = "下部结构损坏类型名")
    private String bottomStructureDamageTypeName;

    @ApiModelProperty(value = "下部结构损坏类型定义")
    private String bottomStructureDamageTypeDefinition;

    @ApiModelProperty(value = "下部结构损坏类型说明")
    private String bottomStructureDamageTypeExplanation;

}
