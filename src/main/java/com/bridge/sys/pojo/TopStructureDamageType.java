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
@ApiModel(value="TopStructureDamageType对象", description="")
public class TopStructureDamageType implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer topStructureDamageTypeId;

    private String topStructureComponentId;

    private String topStructureDamageTypeName;

    private String topStructureDamageTypeDefinition;

    private String topStructureDamageTypeExplanation;


}
