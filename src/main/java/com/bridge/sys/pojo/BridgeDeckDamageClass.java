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
@ApiModel(value="BridgeDeckDamageClass对象", description="")
public class BridgeDeckDamageClass implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer bridgeDeckDamageClassId;

    private Integer bridgeDeckDamageTypeId;

    private String bridgeDeckDamageClassName;

    private Integer bridgeDeckClassDeduction;


}
