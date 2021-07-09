package com.bridge.sys.pojo;

import java.time.LocalDate;
import java.io.Serializable;

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
@ApiModel(value="BottomStructureDetectionResult对象", description="")
public class BottomStructureDetectionResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "桥梁id")
    private String bridgeId;

    @ApiModelProperty(value = "定期检测日期")
    private LocalDate periodicDetectionDate;

    @ApiModelProperty(value = "下部结构损坏类型id", required = true)
    private Integer bottomStructureDamageTypeId;

    @ApiModelProperty(value = "检测的第几跨", required = true)
    private Integer bottomStructureSpanNum;

    @ApiModelProperty(value = "扣分值", required = true)
    private Integer bottomStructureDeduction;

    @ApiModelProperty(value = "下部构件权重", required = true)
    @TableField(exist = false)
    private Double weight;

}
