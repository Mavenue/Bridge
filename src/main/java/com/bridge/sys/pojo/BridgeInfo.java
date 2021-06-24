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
@ApiModel(value="BridgeInfo对象", description="")
public class BridgeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bridgeId;

    private Integer userId;

    private Integer structureId;

    private String bridgeName;

    private String bridgeLocation;

    private String managementOrganization;

    private String maintenanceOrganization;

    private String developmentOrganization;

    private String designOrganization;

    private String supervisorOrganization;

    private String constructionOrganization;

    private LocalDate completionDate;

    private Float cost;

    private String maintenanceType;

    private Integer spanNum;

    private String load;

    private String maintenanceClass;

    private String loadingLimit;

    private String antiknock;

    private Integer skewAngle;

    private String combinationModels;

    private Integer area;

    private Integer length;

    private Integer width;

    private Integer roadwayWidth;

    private Integer sidewalkWidth;

    private String riverWayClass;

    private Integer highestWaterLevel;

    private Integer ordinaryWaterLevel;

    private LocalDate tabulationDate;

    private Boolean deleted;


}
