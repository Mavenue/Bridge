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
@ApiModel(value="BridgeDeckComponentType对象", description="")
public class BridgeDeckComponentType implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bridgeDeckComponentId;

    private String bridgeDeckComponentName;


}
