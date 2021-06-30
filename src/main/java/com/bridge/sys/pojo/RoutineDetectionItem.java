package com.bridge.sys.pojo;

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
@ApiModel(value="RoutineDetectionItem对象", description="")
public class RoutineDetectionItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "日常检测项id")
    private Integer detectionItemId;

    @ApiModelProperty(value = "日常监测项")
    private String detectionItem;


}
