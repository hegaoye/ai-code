/*
 * AI-Code 为您构建代码，享受智慧生活!
 */
package com.aicode.map.entity;

import com.aicode.core.enums.YNEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * 模型关系 的实体类
 *
 * @author hegaoye
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MapRelationship implements java.io.Serializable {
    /**
     * 数据库字段:id  属性显示:id
     */
    @ApiModelProperty(value = "id")
    private java.lang.Long id;
    /**
     * 数据库字段:code  属性显示:关系编码
     */
    @ApiModelProperty(value = "关系编码")
    private java.lang.String code;
    /**
     * 数据库字段:mapClassTableCode  属性显示:映射编码
     */
    @ApiModelProperty(value = "映射编码")
    @TableField("mapClassTableCode")
    private java.lang.String mapClassTableCode;
    /**
     * 数据库字段:associateCode  属性显示:被关联编码
     */
    @ApiModelProperty(value = "被关联编码")
    @TableField("associateCode")
    private java.lang.String associateCode;
    /**
     * 数据库字段:isOneToOne  属性显示:是否一对一 Y N
     */
    @ApiModelProperty(value = "是否一对一 Y N")
    @TableField("isOneToOne")
    private java.lang.String isOneToOne;
    /**
     * 数据库字段:isOneToMany  属性显示:是否一对多Y N
     */
    @ApiModelProperty(value = "是否一对多Y N")
    @TableField("isOneToMany")
    private java.lang.String isOneToMany;
    /**
     * 数据库字段:mainField  属性显示:主表关联属性
     */
    @ApiModelProperty(value = "主表关联属性")
    @TableField("mainField")
    private java.lang.String mainField;
    /**
     * 数据库字段:joinField  属性显示:从表关联属性
     */
    @ApiModelProperty(value = "从表关联属性")
    @TableField("joinField")
    private java.lang.String joinField;


    @TableField(exist = false)
    private MapClassTable associateClass;//被关联对象被查询

    @TableField(exist = false)
    private boolean oneToOne;
    @TableField(exist = false)
    private boolean oneToMany;

    public boolean getOneToOne() {
        return isOneToOne.equals(YNEnum.Y.name()) ? true : false;
    }

    public boolean getOneToMany() {
        return isOneToMany.equals(YNEnum.Y.name()) ? true : false;
    }

}
