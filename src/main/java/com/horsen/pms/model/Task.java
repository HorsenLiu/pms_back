package com.horsen.pms.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Horsen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "Task对象", description = "任务")
public class Task {
    @ApiModelProperty("任务ID")
    private Integer id;
    @ApiModelProperty("任务名称")
    private String name;
    @ApiModelProperty("开始时间")
    private String startTime;
    @ApiModelProperty("结束时间")
    private String endTime;
    @ApiModelProperty("项目ID")
    private String projId;
    @ApiModelProperty("负责人ID")
    private String staffId;
}
