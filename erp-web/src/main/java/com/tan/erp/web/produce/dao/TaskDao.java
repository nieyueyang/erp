package com.tan.erp.web.produce.dao;

import com.tan.erp.web.produce.entity.ProjectEntity;
import com.tan.erp.web.produce.entity.TaskEntity;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/23 10:38
 * @Version 1.0
 * @Description:
 */
@Repository
public class TaskDao {

    @Autowired
    private SqlSession sqlSessionTemplate;

    public List<TaskEntity> queryForList(TaskEntity taskEntity){
        return sqlSessionTemplate.selectList("com.task.selectForList",taskEntity);
    }

    public TaskEntity queryById(Long id){
        return sqlSessionTemplate.selectOne("com.task.selectByPrimaryKey",id);
    }

    public Integer queryForMaxCode(){
        return sqlSessionTemplate.selectOne("com.task.selectForMaxCode");
    }

    public int queryByProjectId(Long projectId){
        return sqlSessionTemplate.selectOne("com.task.selectByProjectId",projectId);
    }

    public TaskEntity save(TaskEntity taskEntity){
        sqlSessionTemplate.insert("com.task.insert",taskEntity);
        return taskEntity;
    }

    public int saveBatch(List<TaskEntity> list){
        return sqlSessionTemplate.insert("com.task.insertBatch",list);
    }

    public int update(TaskEntity taskEntity){
        return sqlSessionTemplate.update("com.task.updateByPrimaryKey",taskEntity);
    }

    public int submit(List<Long> list){
        return sqlSessionTemplate.update("com.task.submit",list);
    }

    public int delete(List<Long> list){
        return sqlSessionTemplate.delete("com.task.deleteByPrimaryKey",list);
    }




}
