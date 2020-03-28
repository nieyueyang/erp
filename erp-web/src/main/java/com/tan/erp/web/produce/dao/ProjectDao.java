package com.tan.erp.web.produce.dao;

import com.tan.erp.web.produce.entity.ContractEntity;
import com.tan.erp.web.produce.entity.ProjectEntity;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/14 1:18
 * @Version 1.0
 * @Description:
 */
@Repository
public class ProjectDao {

    @Autowired
    private SqlSession sqlSessionTemplate;

    public List <ProjectEntity> queryForList(ProjectEntity projectEntity){
        return sqlSessionTemplate.selectList("com.project.selectForList",projectEntity);
    }

    public ProjectEntity queryById(Long id){
        return sqlSessionTemplate.selectOne("com.project.selectByPrimaryKey",id);
    }

    public int queryByContractId(Long ContractId){
        return sqlSessionTemplate.selectOne("com.project.selectByContractId",ContractId);
    }

    public Integer queryForMaxCode(){
        return sqlSessionTemplate.selectOne("com.project.selectForMaxCode");
    }

    public List<ProjectEntity> queryNotImport(ProjectEntity projectEntity){
        List<ProjectEntity>  list = sqlSessionTemplate.selectList("com.project.selectNotImport",projectEntity);
        return sqlSessionTemplate.selectList("com.project.selectNotImport",projectEntity);
    }

    public ProjectEntity save(ProjectEntity projectEntity){
        sqlSessionTemplate.insert("com.project.insert",projectEntity);
        return projectEntity;
    }

    public int saveBatch(List<ProjectEntity> list){
        return sqlSessionTemplate.insert("com.project.insertBatch",list);
    }

    public int update(ProjectEntity projectEntity){
        return sqlSessionTemplate.update("com.project.updateById",projectEntity);
    }

    public int submit(List<Long> list){
        return sqlSessionTemplate.update("com.project.submit",list);
    }

    public int delete(List<Long> list){
        return sqlSessionTemplate.delete("com.project.delete",list);
    }



}
