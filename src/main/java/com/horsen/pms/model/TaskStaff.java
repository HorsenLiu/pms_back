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
@ApiModel(value = "TaskStaff对象", description = "任务_员工")
public class TaskStaff {
  @ApiModelProperty("主键ID")
  private Integer id;
  @ApiModelProperty("任务ID")
  private Integer taskId;
  @ApiModelProperty("员工ID")
  private Integer staffId;
}
