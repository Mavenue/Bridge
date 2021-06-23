package com.bridge.pojo;

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
@ApiModel(value="BridgeDeckDamageType对象", description="")
public class BridgeDeckDamageType implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer bridgeDeckDamageTypeId;

    private String bridgeDeckComponentId;

    private String bridgeDeckDamageTypeName;

    private String bridgeDeckDamageTypeDefinition;

    private String bridgeDeckDamageTypeExplaination;


}
