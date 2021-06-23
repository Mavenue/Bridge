package com.bridge.pojo;

import java.math.BigDecimal;
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
@ApiModel(value="StructureWeight对象", description="")
public class StructureWeight implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer structureId;

    private BigDecimal bridgeDeckWeight;

    private BigDecimal bottomStructureWeight;

    private BigDecimal topStructureWeight;


}
