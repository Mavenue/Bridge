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
@ApiModel(value="BottomStructureDamageType对象", description="")
public class BottomStructureDamageType implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer bottomStructureDamageTypeId;

    private String bottomStructureComponentId;

    private String bottomStructureDamageTypeName;

    private String bottomStructureDamageTypeDefinition;

    private String bottomStructureDamageTypeExplanation;


}
