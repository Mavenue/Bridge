package com.bridge.sys.pojo;

import java.time.LocalDate;
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
@ApiModel(value="RoutineDetectionResult对象", description="")
public class RoutineDetectionResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer detectionItemId;

    private String bridgeId;

    private LocalDate routineDetectionDate;

    private String isCompletion;

    private String damageType;

    private String damageDegree;

    private String damageLocation;

    private String remark;


}
