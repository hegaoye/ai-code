/*
 * AI-Code 为您构建代码，享受智慧生活!
 */
package com.aicode.project.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * 项目sql脚本 的实体类
 *
 * @author hegaoye
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProjectSql implements java.io.Serializable {
    /**
     * 数据库字段:id  属性显示:
     */
    @ApiModelProperty(value = "")
    private java.lang.Long id;
    /**
     * 数据库字段:projectCode  属性显示:项目编码
     */
    @ApiModelProperty(value = "项目编码")
    @TableField("projectCode")
    private java.lang.String projectCode;
    /**
     * 数据库字段:code  属性显示:tsql编码
     */
    @ApiModelProperty(value = "tsql编码")
    private java.lang.String code;
    /**
     * 数据库字段:tsql  属性显示:sql脚本
     */
    @ApiModelProperty(value = "sql脚本")
    private java.lang.String tsql;
    /**
     * 数据库字段:state  属性显示:状态：停用[Disenable]，启用[Enable]
     */
    @ApiModelProperty(value = "状态：停用[Disenable]，启用[Enable]")
    private java.lang.String state;

}
