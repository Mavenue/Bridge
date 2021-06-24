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
@ApiModel(value="TopStructureDamageClass对象", description="")
public class TopStructureDamageClass implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer topStructureDamageClassId;

    private Integer topStructureDamageTypeId;

    private String topStructureDamageClassName;

    private Integer topStructureClassDeduction;


}
