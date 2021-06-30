package com.bridge.sys.pojo.dto;

import com.bridge.sys.pojo.RoutineDetection;
import com.bridge.sys.pojo.RoutineDetectionResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "RoutineDetectionResultsDto对象", description = "")
public class RoutineDetectionResultsDto {

    @ApiModelProperty(value = "日常检查对象", required = true)
    private RoutineDetection routineDetection;

    @ApiModelProperty(value = "日常检查结果集", required = true)
    List<RoutineDetectionResult> routineDetectionResults;
}
