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
@ApiModel(value="PeriodicDetection对象", description="")
public class PeriodicDetection implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "bridgeId")
    private String bridgeId;

    @ApiModelProperty(value = "定期检测日期")
    private LocalDate periodicDetectionDate;

    @ApiModelProperty(value = "userId")
    private Integer userId;

    @ApiModelProperty(value = "bci")
    private Integer bci;

    @ApiModelProperty(value = "bsi")
    private Integer bsi;

    @ApiModelProperty(value = "topBci")
    private Integer topBci;

    @ApiModelProperty(value = "topBsi")
    private Integer topBsi;

    @ApiModelProperty(value = "bottomBci")
    private Integer bottomBci;

    @ApiModelProperty(value = "bottomBsi")
    private Integer bottomBsi;

    @ApiModelProperty(value = "bridgeDeckBci")
    private Integer bridgeDeckBci;

    @ApiModelProperty(value = "bridgeDeckBsi")
    private Integer bridgeDeckBsi;

    @ApiModelProperty(value = "完好状况评估等级")
    private String intactConditionClass;

    @ApiModelProperty(value = "结构状况评估等级")
    private String structureConditionClass;


}
