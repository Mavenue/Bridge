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
@ApiModel(value="BridgeDeckDamageType对象", description="")
public class BridgeDeckDamageType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "桥面系损坏类型id")
    private Integer bridgeDeckDamageTypeId;

    @ApiModelProperty(value = "桥面系构件类型id")
    private String bridgeDeckComponentId;

    @ApiModelProperty(value = "桥面系损坏类型名")
    private String bridgeDeckDamageTypeName;

    @ApiModelProperty(value = "桥面系损坏类型定义")
    private String bridgeDeckDamageTypeDefinition;

    @ApiModelProperty(value = "桥面系损坏类型说明")
    private String bridgeDeckDamageTypeExplanation;

    @ApiModelProperty(value = "桥面系损坏类型等级")
    @TableField(exist = false)
    private List<BridgeDeckDamageClass> bridgeDeckDamageClasses;
}
