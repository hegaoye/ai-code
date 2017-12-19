/*
 * Powered By [lixin]
 *
 */

package com.rzhkj.project.entity;

/**
 * 工具状态：停用[Disenable]，启用[Enable],删除[Delete]
 *
 * @author lixin hegaoye@qq.com
 * @version 1.0
 * @since 1.0
 */
public enum ToolsStateEnum implements java.io.Serializable {
    Enable("启用"),
    Disenable("停用"),
    Delete("删除");
    public String val;

    ToolsStateEnum(String val) {
        this.val = val;
    }

    /**
     * 根据状态名称查询状态
     *
     * @param stateName
     * @return
     */
    public static ToolsStateEnum getEnum(String stateName) {
        for (ToolsStateEnum projectStateEnum : ToolsStateEnum.values()) {
            if (projectStateEnum.name().equalsIgnoreCase(stateName)) {
                return projectStateEnum;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }
}

