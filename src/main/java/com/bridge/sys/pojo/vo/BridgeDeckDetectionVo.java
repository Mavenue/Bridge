package com.bridge.sys.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.bridge.sys.pojo.BridgeDeckDamageType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "BridgeDeckDetectionVo对象")
public class BridgeDeckDetectionVo {

    @ApiModelProperty(value = "桥面系构件类型名")
    private String bridgeDeckComponentName;

    @ApiModelProperty(value = "桥面系构件权重")
    private Double weight;

    @ApiModelProperty(value = "桥面系构件对应的损坏类型")
    private List<BridgeDeckDamageTypeVo> bridgeDeckDamageTypeVos;


}
