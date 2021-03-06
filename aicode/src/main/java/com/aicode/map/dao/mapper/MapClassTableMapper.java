package com.aicode.map.dao.mapper;

import com.aicode.map.entity.MapClassTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * MapClassTable mapper
 * 直接与xml映射
 *
 * @author hegaoye
 */
@Repository
public interface MapClassTableMapper extends BaseMapper<MapClassTable> {

    MapClassTable selectByCode(@Param("code") String code);
}
