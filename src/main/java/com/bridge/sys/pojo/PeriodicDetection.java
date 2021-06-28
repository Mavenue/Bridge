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
@ApiModel(value="PeriodicDetection对象", description="")
public class PeriodicDetection implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bridgeId;

    private LocalDate periodicDetectionDate;

    private Integer userId;

    private Integer bci;

    private Integer bsi;

    private Integer topBci;

    private Integer topBsi;

    private Integer bottomBci;

    private Integer bottomBsi;

    private Integer bridgeDeckBci;

    private Integer bridgeDeckBsi;

    private String intactConditionClass;

    private String structureConditionClass;


}
