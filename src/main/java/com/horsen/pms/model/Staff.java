package com.horsen.pms.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author Horsen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "Staff对象", description = "员工")
public class Staff {
    @ApiModelProperty("员工ID")
    private Integer id;
    @ApiModelProperty("员工姓名")
    private String name;
    @ApiModelProperty("员工年龄")
    private Integer age;
    @ApiModelProperty("毕业学校")
    private String graduateSchool;
    @ApiModelProperty("学历")
    private String degree;
    @ApiModelProperty("毕业时间")
    private Date graduateTime;
    @ApiModelProperty("逻辑删除(1已删除,0未删除)")
    private Boolean isDeleted;
}
