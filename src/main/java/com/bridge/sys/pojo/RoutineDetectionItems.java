package com.bridge.sys.pojo;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
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
@ApiModel(value="RoutineDetectionItems对象", description="")
public class RoutineDetectionItems implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer detectionItemId;

    private String detectionItem;


}