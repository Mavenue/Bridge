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
@ApiModel(value="RoutineDetection对象", description="")
public class RoutineDetection implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "桥梁id", required = true)
    private String bridgeId;

    @ApiModelProperty(value = "日常监测日期", required = false)
    private LocalDate routineDetectionDate;

    @ApiModelProperty(value = "用户id", required = false)
    private Integer userId;


}
