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
@ApiModel(value = "ProjStaff对象", description = "项目_员工")
public class ProjStaff {
    @ApiModelProperty("项目ID")
    private Integer projId;
    @ApiModelProperty("员工ID")
    private Integer staffId;

    private String projName;
    private String staffName;
}
