/*
 * AI-Code 为您构建代码，享受智慧生活!
 */
package com.aicode.project.service;

import com.baidu.fsg.uid.UidGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aicode.project.dao.ProjectMapDAO;
import com.aicode.project.dao.mapper.ProjectMapMapper;
import com.aicode.project.entity.ProjectMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;


/**
 * 项目数据表
 *
 * @author hegaoye
 */
@Slf4j
@Service
public class ProjectMapServiceImpl extends ServiceImpl<ProjectMapMapper, ProjectMap> implements ProjectMapService {

    @Autowired
    private ProjectMapDAO projectMapDAO;

    @Autowired
    private UidGenerator uidGenerator;

    @Override
    public boolean save(ProjectMap entity) {
//        entity.setId(String.valueOf(uidGenerator.getUID()));
        return super.save(entity);
    }

    /**
     * 分页查询 投注项水位
     *
     * @param queryWrapper 查询条件
     * @param offset       起始行
     * @param limit        步长
     * @return List<ProjectMap>
     */
    @Override
    public List<ProjectMap> list(QueryWrapper<ProjectMap> queryWrapper, int offset, int limit) {
        return projectMapDAO.list(queryWrapper, offset, limit);
    }
}


