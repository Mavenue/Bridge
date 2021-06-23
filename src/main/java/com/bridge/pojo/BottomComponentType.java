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
@ApiModel(value="BottomComponentType对象", description="")
public class BottomComponentType implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bottomStructureComponentId;

    private String bottomStructureComponentName;


}
