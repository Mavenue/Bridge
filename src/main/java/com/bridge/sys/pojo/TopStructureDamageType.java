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
@ApiModel(value="TopStructureDamageType对象", description="")
public class TopStructureDamageType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "上部结构损坏类型id")
    private Integer topStructureDamageTypeId;

    @ApiModelProperty(value = "上部构件类型id")
    private String topStructureComponentId;

    @ApiModelProperty(value = "上部结构损坏类型名")
    private String topStructureDamageTypeName;

    @ApiModelProperty(value = "上部结构损坏类型定义")
    private String topStructureDamageTypeDefinition;

    @ApiModelProperty(value = "上部结构损坏类型说明")
    private String topStructureDamageTypeExplanation;
}
