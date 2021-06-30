package com.bridge.sys.pojo;

import java.time.LocalDate;
import java.io.Serializable;
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
@ApiModel(value="RoutineDetectionResult对象", description="")
public class RoutineDetectionResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "日常检测项id", required = true)
    private Integer detectionItemId;

    @ApiModelProperty(value = "桥梁id", required = true)
    private String bridgeId;

    @ApiModelProperty(value = "检测日期", required = true)
    private LocalDate routineDetectionDate;

    @ApiModelProperty(value = "是否完好", required = true)
    private String isCompletion;

    @ApiModelProperty(value = "损坏类型")
    private String damageType;

    @ApiModelProperty(value = "损坏程度")
    private String damageDegree;

    @ApiModelProperty(value = "损坏位置")
    private String damageLocation;

    @ApiModelProperty(value = "备注")
    private String remark;


}
