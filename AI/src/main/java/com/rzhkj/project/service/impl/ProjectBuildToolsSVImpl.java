/*
 * Powered By [lixin]
 * 代码脚手架工具生成 [rapid-framework]
 */

package com.rzhkj.project.service.impl;

import com.baidu.fsg.uid.UidGenerator;
import com.rzhkj.core.base.BaseMybatisDAO;
import com.rzhkj.core.base.BaseMybatisSVImpl;
import com.rzhkj.project.dao.ProjectBuildToolsDAO;
import com.rzhkj.project.entity.ProjectBuildTools;
import com.rzhkj.project.service.ProjectBuildToolsSV;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Component
@Service
public class ProjectBuildToolsSVImpl extends BaseMybatisSVImpl<ProjectBuildTools, Long> implements ProjectBuildToolsSV {

    @Resource
    private ProjectBuildToolsDAO projectBuildToolsDAO;

    @Resource
    private UidGenerator uidGenerator;

    @Override
    protected BaseMybatisDAO getBaseMybatisDAO() {
        return projectBuildToolsDAO;
    }

}
