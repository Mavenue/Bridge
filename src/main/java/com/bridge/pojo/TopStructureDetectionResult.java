package com.bridge.pojo;

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
@ApiModel(value="TopStructureDetectionResult对象", description="")
public class TopStructureDetectionResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bridgeId;

    private LocalDate periodicDetectionDate;

    private Integer topStructureDamageTypeId;

    private Integer topStructureSpanNum;

    private Integer topStructureDeduction;


}
