package com.tan.erp.web.produce.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tan.erp.web.produce.dao.TaskDao;
import com.tan.erp.web.produce.entity.ProjectEntity;
import com.tan.erp.web.produce.entity.TaskEntity;
import com.tan.erp.web.station.service.Station2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/7 20:35
 * @Version 1.0
 * @Description:
 */
@Service
public class TaskService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private Station2Service station2Service;

    public PageInfo<TaskEntity> queryForPage(TaskEntity taskEntity){
        String orderby = "";
        String sidx = taskEntity.getSidx();
        if (!StringUtils.isEmpty(sidx)) {
            String sord = taskEntity.getSord();
            orderby = sidx + " " + sord;
        }
        PageHelper.startPage(taskEntity.getPageNum(), taskEntity.getPageSize(), orderby);
        List <TaskEntity> list = taskDao.queryForList(taskEntity);
        PageInfo <TaskEntity> PageUser = new PageInfo<>(list);
        return PageUser;
    }

    public TaskEntity queryById(Long id){
        return taskDao.queryById(id);
    }

    public Integer queryForMaxCode(){
        return taskDao.queryForMaxCode();
    }

    public int queryByProjectId(Long projectId){
        return taskDao.queryByProjectId(projectId);
    }

    public TaskEntity save(TaskEntity taskEntity){
        String taskCode = taskEntity.getTaskCode();
        if(StringUtils.isEmpty(taskCode)){
            taskCode = "T" + LocalDate.now().toString().replace("-", "");
            Integer maxCode = taskDao.queryForMaxCode();
            if(StringUtils.isEmpty(maxCode)){
                taskCode =taskCode + String.format("%04d", 1);
            }else{
                taskCode =taskCode + String.format("%04d", maxCode + 1);
            }
        }

        taskEntity.setTaskCode(taskCode);
        return taskDao.save(taskEntity);
    }

    public int saveBatch(List<TaskEntity> list){
        return taskDao.saveBatch(list);
    }

    public int update(TaskEntity taskEntity){
        return taskDao.update(taskEntity);
    }

    public int submit(List<Long> list){
        return taskDao.submit(list);
    }

    public int delete(List<Long> list){
        return taskDao.delete(list);
    }


    public int addToTask(TaskEntity taskEntity) throws Exception {
        return station2Service.insert(taskEntity);
    }



}
