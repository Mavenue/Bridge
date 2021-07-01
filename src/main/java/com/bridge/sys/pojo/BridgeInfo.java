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
@ApiModel(value="BridgeInfo对象", description="")
public class BridgeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "桥梁id")
    private String bridgeId;

    @ApiModelProperty(value = "用户id", required = true)
    private Integer userId;

    @ApiModelProperty(value = "桥梁结构类型id", required = true)
    private Integer structureId;

    @ApiModelProperty(value = "桥梁名称", required = true)
    private String bridgeName;

    @ApiModelProperty(value = "桥梁所在位置", required = true)
    private String bridgeLocation;

    @ApiModelProperty(value = "管理单位", required = true)
    private String managementOrganization;

    @ApiModelProperty(value = "养护单位", required = true)
    private String maintenanceOrganization;

    @ApiModelProperty(value = "建设单位", required = true)
    private String developmentOrganization;

    @ApiModelProperty(value = "设计单位", required = true)
    private String designOrganization;

    @ApiModelProperty(value = "监理单位", required = true)
    private String supervisorOrganization;

    @ApiModelProperty(value = "施工单位", required = true)
    private String constructionOrganization;

    @ApiModelProperty(value = "建成日期", required = true)
    private LocalDate completionDate;

    @ApiModelProperty(value = "总造价", required = true)
    private Float cost;

    @ApiModelProperty(value = "养护类别", required = true)
    private String maintenanceType;

    @ApiModelProperty(value = "桥梁跨数", required = true)
    private Integer spanNum;

    @TableField(value = "`load`")
    @ApiModelProperty(value = "设计荷载", required = true)
    private String load;

    @ApiModelProperty(value = "养护等级", required = true)
    private String maintenanceClass;

    @ApiModelProperty(value = "限载标准", required = true)
    private String loadingLimit;

    @ApiModelProperty(value = "抗震烈度", required = true)
    private String antiknock;

    @ApiModelProperty(value = "正斜交角", required = true)
    private Integer skewAngle;

    @ApiModelProperty(value = "跨径组合", required = true)
    private String combinationModels;

    @ApiModelProperty(value = "桥面面积", required = true)
    private Integer area;

    @ApiModelProperty(value = "桥梁总长", required = true)
    private Integer length;

    @ApiModelProperty(value = "桥梁总宽", required = true)
    private Integer width;

    @ApiModelProperty(value = "车行道净宽", required = true)
    private Integer roadwayWidth;

    @ApiModelProperty(value = "人行道净宽", required = true)
    private Integer sidewalkWidth;

    @ApiModelProperty(value = "河道等级", required = true)
    private String riverWayClass;

    @ApiModelProperty(value = "最高水位", required = true)
    private Integer highestWaterLevel;

    @ApiModelProperty(value = "常水位", required = true)
    private Integer ordinaryWaterLevel;

    @ApiModelProperty(value = "制表日期", required = true)
    private LocalDate tabulationDate;

    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;


}
