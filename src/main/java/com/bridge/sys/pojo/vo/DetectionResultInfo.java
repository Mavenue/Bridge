package com.bridge.sys.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;


@Data
@Accessors(chain = true)
@ApiModel(value = "DetectionInfo对象")
public class DetectionResultInfo {

    private LocalDate periodicDetectionDate;

    private  Integer spanNum;

    private String username;

    private String bridgeId;
}
