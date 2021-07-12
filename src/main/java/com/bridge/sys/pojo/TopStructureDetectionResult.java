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
@ApiModel(value="TopStructureDetectionResult对象", description="")
public class TopStructureDetectionResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "桥梁id")
    private String bridgeId;

    @ApiModelProperty(value = "定期检测日期")
    private LocalDate periodicDetectionDate;

    @ApiModelProperty(value = "上部结构损坏类型id", required = true)
    private Integer topStructureDamageTypeId;

    @ApiModelProperty(value = "检测的第几跨", required = true)
    private Integer topStructureSpanNum;

    @ApiModelProperty(value = "扣分值", required = true)
    private Integer topStructureDeduction;

}
