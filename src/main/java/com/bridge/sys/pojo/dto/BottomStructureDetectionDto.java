package com.bridge.sys.pojo.dto;


import com.baomidou.mybatisplus.annotation.TableField;
import com.bridge.sys.pojo.BottomStructureDetectionResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value = "BottomStructureDetectionDto对象")
public class BottomStructureDetectionDto {

    @ApiModelProperty(value = "下部构件权重", required = true)
    private Double weight;

    @ApiModelProperty(value = "下部构件对应的损坏类型检测结果", required = true)
    private List<BottomStructureDetectionResult> bottomStructureDetectionResults;
}
