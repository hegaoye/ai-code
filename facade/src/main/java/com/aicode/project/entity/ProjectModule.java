/*
 * AI-Code 为您构建代码，享受智慧生活!
 */
package com.aicode.project.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import com.aicode.module.entity.Module;

/**
 * 项目选择模块 的实体类
 *
 * @author hegaoye
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProjectModule implements java.io.Serializable {
    /**
     * 数据库字段:id  属性显示:id
     */
    @ApiModelProperty(value = "id")
    private java.lang.Long id;
    /**
     * 数据库字段:projectCode  属性显示:项目编码
     */
    @ApiModelProperty(value = "项目编码")
    @TableField("projectCode")
    private java.lang.String projectCode;
    /**
     * 数据库字段:moduleCode  属性显示:模块编码
     */
    @ApiModelProperty(value = "模块编码")
    @TableField("moduleCode")
    private java.lang.String moduleCode;

    @TableField(exist = false)
    private Module module;

}
