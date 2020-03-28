package com.tan.erp.web.produce.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tan.erp.web.produce.dao.ProjectDao;
import com.tan.erp.web.produce.entity.ContractEntity;
import com.tan.erp.web.produce.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/14 1:32
 * @Version 1.0
 * @Description:
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectDao projectDao;

    public PageInfo<ProjectEntity> queryForPage(ProjectEntity projectEntity){
        String orderby = "";
        String sidx = projectEntity.getSidx();
        if (!StringUtils.isEmpty(sidx)) {
            String sord = projectEntity.getSord();
            orderby = sidx + " " + sord;
        }
        PageHelper.startPage(projectEntity.getPageNum(), projectEntity.getPageSize(), orderby);
        List <ProjectEntity> list = projectDao.queryForList(projectEntity);
        PageInfo <ProjectEntity> PageUser = new PageInfo <>(list);
        return PageUser;
    }

    public ProjectEntity queryById(Long id){
        return projectDao.queryById(id);
    }

    public Integer queryForMaxCode(){
        return projectDao.queryForMaxCode();
    }

    public int queryByContractId(Long ContractId){
        return projectDao.queryByContractId(ContractId);
    }

    public PageInfo<ProjectEntity> queryNotImport(ProjectEntity projectEntity){
        String orderby = "";
        String sidx = projectEntity.getSidx();
        if (!StringUtils.isEmpty(sidx)) {
            String sord = projectEntity.getSord();
            orderby = sidx + " " + sord;
        }
        PageHelper.startPage(projectEntity.getPageNum(), projectEntity.getPageSize(), orderby);
        List<ProjectEntity> list = projectDao.queryNotImport(projectEntity);
        PageInfo <ProjectEntity> PageUser = new PageInfo <>(list);
        return PageUser;
    }

    public ProjectEntity save(ProjectEntity projectEntity){
        String projectCode = projectEntity.getProjectCode();
        if(StringUtils.isEmpty(projectCode)){
            projectCode = "P" + LocalDate.now().toString().replace("-", "");
            Integer maxCode = projectDao.queryForMaxCode();
            if(StringUtils.isEmpty(maxCode)){
                projectCode =projectCode + String.format("%04d", 1);
            }else{
                projectCode =projectCode + String.format("%04d", maxCode + 1);
            }
        }

        projectEntity.setProjectCode(projectCode);
        return projectDao.save(projectEntity);
    }

    public int saveBatch(List<ProjectEntity> list){
        return projectDao.saveBatch(list);
    }

    public int update(ProjectEntity projectEntity){
        return projectDao.update(projectEntity);
    }

    public int submit(List<Long> list){
        return projectDao.submit(list);
    }

    public int delete(List<Long> list){
        return projectDao.delete(list);
    }


}
