/*
 * Powered By [lixin]
 *
 */

package com.rzhkj.project.service;

import com.rzhkj.core.base.BaseMybatisSV;
import com.rzhkj.project.entity.MapClassTable;

import java.util.List;

public interface MapClassTableSV extends BaseMybatisSV<MapClassTable, Long> {

    /**
     * 解析表信息
     *
     * @param projectCode 项目编码
     * @return true/false
     */
    boolean parseTableInfo(String projectCode);

    /**
     * 根据项目编码查询所有表信息
     *
     * @param projectCode 项目编码
     * @return List<MapClassTable>
     */
    List<MapClassTable> query(String projectCode);

}
