package com.tan.erp.web.produce.ctrl;

import com.github.pagehelper.PageInfo;
import com.tan.erp.common.annotation.ParaNotNull;
import com.tan.erp.common.dto.Result;
import com.tan.erp.web.produce.entity.ContractEntity;
import com.tan.erp.web.produce.entity.ProjectEntity;
import com.tan.erp.web.produce.entity.TaskEntity;
import com.tan.erp.web.produce.service.ProjectService;
import com.tan.erp.web.produce.service.TaskService;
import com.tan.erp.web.util.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/14 1:38
 * @Version 1.0
 * @Description:
 */

@RestController
@RequestMapping("produce/project")
public class projectCtrl {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private TaskService taskService;


    @RequestMapping(value="/queryForPage",method = RequestMethod.GET)
    public Result queryForPage(ProjectEntity projectEntity){
        if(StringUtils.isEmpty(projectEntity.getPageNum())){
            projectEntity.setPageNum(1);
        }

        if(StringUtils.isEmpty(projectEntity.getPageSize())){
            projectEntity.setPageSize(10);
        }
        PageInfo<ProjectEntity> page = projectService.queryForPage(projectEntity);
        return new Result(page);
    }

    @RequestMapping(value="/queryNotImport",method = RequestMethod.GET)
    public Result queryNotImport(ProjectEntity projectEntity){
        if(StringUtils.isEmpty(projectEntity.getPageNum())){
            projectEntity.setPageNum(1);
        }

        if(StringUtils.isEmpty(projectEntity.getPageSize())){
            projectEntity.setPageSize(10);
        }
        PageInfo <ProjectEntity> page = projectService.queryNotImport(projectEntity);
        return new Result(page);
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public Result save(@RequestBody ProjectEntity projectEntity){
        projectEntity.setStatus(0);
        projectEntity.setCreateUser(UserAgent.getAccount());
        projectEntity.setCreateUserName(UserAgent.getUsername());
        projectEntity.setCreateTime(Instant.now());
        projectService.save(projectEntity);
        return new Result(projectEntity);
    }


    @ParaNotNull(ParaName = { "projectName:工程名称不能为空","constructionUnit:施工单位不能为空"})
    @RequestMapping(value="/saveAndSubmit",method = RequestMethod.POST)
    public Result saveAndSubmit(@RequestBody ProjectEntity projectEntity){
        projectEntity.setStatus(1);
        projectEntity.setCreateUser(UserAgent.getAccount());
        projectEntity.setCreateUserName(UserAgent.getUsername());
        projectEntity.setCreateTime(Instant.now());
        projectService.save(projectEntity);
        return new Result(projectEntity);
    }

    @ParaNotNull(ParaName = {"projectCode:工程编号不能为空", "projectName:工程名称不能为空","constructionUnit:施工单位不能为空",
    "accountingUnit:核算单位不能为空"})
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Result update(@RequestBody ProjectEntity projectEntity){
        //projectEntity.setProjectCode("");
        projectEntity.setCreateUser("");
        projectEntity.setCreateUserName("");
        projectEntity.setCreateTime(null);

        projectEntity.setModifyUser(UserAgent.getAccount());
        projectEntity.setModifyTime(Instant.now());

        int i = projectService.update(projectEntity);
        return new Result(i);
    }

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public Result submit(@RequestBody Long[] ids){
        List list = Arrays.asList(ids);
        for(Long id : ids){
            ProjectEntity projectEntity = projectService.queryById(id);

            if(StringUtils.isEmpty(projectEntity.getProjectName())){
                return new Result("工程编号：" + projectEntity.getProjectCode() +",工程名称不能为空");
            }

            if(StringUtils.isEmpty(projectEntity.getConstructionUnit())){
                return new Result("工程编号：" + projectEntity.getProjectCode() + ",施工单位不能为空");
            }

            if(StringUtils.isEmpty(projectEntity.getAccountingUnit())){
                return new Result("工程编号：" + projectEntity.getProjectCode() + ",核算单位不能为空");
            }

        }
        int i = projectService.submit(list);
        return new Result(i);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(@RequestBody Long[] ids){
        List list = Arrays.asList(ids);
        for(Long id : ids){
            ProjectEntity projectEntity = projectService.queryById(id);
            if(projectEntity.getStatus() == 1){
                return new Result("工程编号：" + projectEntity.getProjectCode() +",数据已提交不能删除");
            }
        }
        int i = projectService.delete(list);
        return new Result(i);
    }

    @RequestMapping(value = "/importProject",method = RequestMethod.POST)
    public Result importProject(@RequestBody List<ProjectEntity> list){
        List<TaskEntity> listTask = new ArrayList <>();
        //查找数据库中的最大值
        Integer maxCode = taskService.queryForMaxCode();
        for(ProjectEntity projectEntity : list){
            if(projectEntity.getStatus() == 0){
                return new Result("工程编号：" + projectEntity.getProjectCode() +",数据未提交，不能导入工程");
            }

            int count = taskService.queryByProjectId(projectEntity.getId());
            if(count > 0 ){
                return new Result("工程编号：" + projectEntity.getProjectCode() +",已导入任务单，不能多次导入");
            }

            String taskCode = "T" + LocalDate.now().toString().replace("-", "");

            //生成taskCode
            if(StringUtils.isEmpty(maxCode)){
                maxCode =1;
            }else{
                maxCode = maxCode +1;
            }

            taskCode = taskCode + String.format("%04d", maxCode);

            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setTaskCode(taskCode);
            taskEntity.setProjectId(projectEntity.getId());
            taskEntity.setProjectName(projectEntity.getProjectName());
            //taskEntity.setStationId();
            //taskEntity.setCustomerId();
            //taskEntity.setCustomerName();
            //taskEntity.setPourMethod();
            //taskEntity.setPourPart();
            taskEntity.setStatus(0);
            taskEntity.setCreateUser(UserAgent.getAccount());
            taskEntity.setCreateUserName(UserAgent.getUsername());
            taskEntity.setCreateTime(Instant.now());

            listTask.add(taskEntity);
        }

        //批量插入工程表
        int i = taskService.saveBatch(listTask);
        return new Result(i);
    }



}
