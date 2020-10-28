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
@ApiModel(value = "ProjTask对象", description = "项目_任务")
public class ProjTask {
    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("项目ID")
    private Integer projId;
    @ApiModelProperty("任务ID")
    private Integer taskId;
}
