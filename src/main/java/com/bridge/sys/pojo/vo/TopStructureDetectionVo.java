package com.bridge.sys.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.bridge.sys.pojo.TopStructureDamageType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "TopStructureDetectionVo对象")
public class TopStructureDetectionVo {

    @ApiModelProperty(value = "上部构件类型名")
    private String topStructureComponentName;

    @ApiModelProperty(value = "上部构件权重")
    private Double weight;

    @ApiModelProperty(value = "上部构件对应的损坏类型")
    private List<TopStructureDamageTypeVo> topStructureDamageTypeVoList;
}
