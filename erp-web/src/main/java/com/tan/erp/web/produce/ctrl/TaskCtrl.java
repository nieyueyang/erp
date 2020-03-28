package com.tan.erp.web.produce.ctrl;

import com.github.pagehelper.PageInfo;
import com.tan.erp.common.annotation.ParaNotNull;
import com.tan.erp.common.dto.Result;
import com.tan.erp.web.produce.entity.ProjectEntity;
import com.tan.erp.web.produce.entity.TaskEntity;
import com.tan.erp.web.produce.service.TaskService;
import com.tan.erp.web.util.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/23 23:00
 * @Version 1.0
 * @Description:
 */
@RestController
@RequestMapping("produce/task")
public class TaskCtrl {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value="/queryForPage",method = RequestMethod.GET)
    public Result queryForPage(TaskEntity taskEntity){
        if(StringUtils.isEmpty(taskEntity.getPageNum())){
            taskEntity.setPageNum(1);
        }

        if(StringUtils.isEmpty(taskEntity.getPageSize())){
            taskEntity.setPageSize(10);
        }
        PageInfo <TaskEntity> page = taskService.queryForPage(taskEntity);
        return new Result(page);
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public Result save(@RequestBody TaskEntity taskEntity){
        taskEntity.setStatus(0);
        taskEntity.setCreateUser(UserAgent.getAccount());
        taskEntity.setCreateUserName(UserAgent.getUsername());
        taskEntity.setCreateTime(Instant.now());
        taskService.save(taskEntity);
        return new Result(taskEntity);
    }

    @ParaNotNull(ParaName = { "projectId:请选择工程","recipeId:请选择配比"})
    @RequestMapping(value="/saveAndSubmit",method = RequestMethod.POST)
    public Result saveAndSubmit(@RequestBody TaskEntity taskEntity){
        taskEntity.setStatus(1);
        taskEntity.setCreateUser(UserAgent.getAccount());
        taskEntity.setCreateUserName(UserAgent.getUsername());
        taskEntity.setCreateTime(Instant.now());
        taskService.save(taskEntity);
        return new Result(taskEntity);
    }

    @ParaNotNull(ParaName = {"taskCode:任务单号不能为空"})
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Result update(@RequestBody TaskEntity taskEntity){
        taskEntity.setModifyUser(UserAgent.getAccount());
        taskEntity.setModifyTime(Instant.now());
        int i = taskService.update(taskEntity);
        return new Result(i);
    }

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public Result submit(@RequestBody Long[] ids){
        for(Long id : ids){
            TaskEntity taskEntity = taskService.queryById(id);
            if(StringUtils.isEmpty(taskEntity.getProjectId())){
                return new Result("任务单号号：" + taskEntity.getTaskCode() +",请选择工程");
            }

            if(StringUtils.isEmpty(taskEntity.getRecipeId())){
                return new Result("任务单号号：" + taskEntity.getTaskCode() +",请选择配比");
            }
        }
        List list = Arrays.asList(ids);
        int i = taskService.submit(list);
        return new Result(i);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(@RequestBody Long[] ids){
        for(Long id : ids){
            TaskEntity taskEntity = taskService.queryById(id);
            if(taskEntity.getStatus() == 1){
                return new Result("任务单号：" + taskEntity.getTaskCode() +",数据已提交不能删除");
            }
        }
        List list = Arrays.asList(ids);
        int i = taskService.delete(list);
        return new Result(i);
    }





}
