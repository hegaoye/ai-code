/*
 * AI-Code 为您构建代码，享受智慧生活!
 */
package com.aicode.project.service;

import com.baidu.fsg.uid.UidGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aicode.project.dao.ProjectJobLogsDAO;
import com.aicode.project.dao.mapper.ProjectJobLogsMapper;
import com.aicode.project.entity.ProjectJobLogs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;


/**
 * 任务日志
 *
 * @author hegaoye
 */
@Slf4j
@Service
public class ProjectJobLogsServiceImpl extends ServiceImpl<ProjectJobLogsMapper, ProjectJobLogs> implements ProjectJobLogsService {

    @Autowired
    private ProjectJobLogsDAO projectJobLogsDAO;

    @Autowired
    private UidGenerator uidGenerator;

    @Override
    public boolean save(ProjectJobLogs entity) {
//        entity.setId(String.valueOf(uidGenerator.getUID()));
        return super.save(entity);
    }

    /**
     * 分页查询 投注项水位
     *
     * @param queryWrapper 查询条件
     * @param offset       起始行
     * @param limit        步长
     * @return List<ProjectJobLogs>
     */
    @Override
    public List<ProjectJobLogs> list(QueryWrapper<ProjectJobLogs> queryWrapper, int offset, int limit) {
        return projectJobLogsDAO.list(queryWrapper, offset, limit);
    }
}


