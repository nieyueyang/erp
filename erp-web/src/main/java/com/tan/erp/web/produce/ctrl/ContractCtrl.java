package com.tan.erp.web.produce.ctrl;

import com.github.pagehelper.PageInfo;
import com.tan.erp.common.annotation.ParaNotNull;
import com.tan.erp.common.dto.Result;
import com.tan.erp.web.produce.entity.ContractEntity;
import com.tan.erp.web.produce.entity.ProjectEntity;
import com.tan.erp.web.produce.service.ContractService;
import com.tan.erp.web.produce.service.ProjectService;
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
 * @Date: 2020/3/17 23:55
 * @Version 1.0
 * @Description:
 */
@RestController
@RequestMapping("produce/contract")
public class ContractCtrl {

    @Autowired
    private ContractService contractService;
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value="/queryForPage",method = RequestMethod.GET)
    public Result queryForPage(ContractEntity contractEntity){
        if(StringUtils.isEmpty(contractEntity.getPageNum())){
            contractEntity.setPageNum(1);
        }

        if(StringUtils.isEmpty(contractEntity.getPageSize())){
            contractEntity.setPageSize(10);
        }
        PageInfo <ContractEntity> page = contractService.queryForPage(contractEntity);
        return new Result(page);
    }

    @RequestMapping(value="/queryNotImport",method = RequestMethod.GET)
    public Result queryNotImport(ContractEntity contractEntity){
        if(StringUtils.isEmpty(contractEntity.getPageNum())){
            contractEntity.setPageNum(1);
        }

        if(StringUtils.isEmpty(contractEntity.getPageSize())){
            contractEntity.setPageSize(10);
        }
        PageInfo <ContractEntity> page = contractService.queryNotImport(contractEntity);
        return new Result(page);
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public Result save(@RequestBody ContractEntity contractEntity){
        contractEntity.setStatus(0);
        contractEntity.setCreateUser(UserAgent.getAccount());
        contractEntity.setCreateUserName(UserAgent.getUsername());
        contractEntity.setCreateTime(Instant.now());

        contractService.save(contractEntity);
        return new Result(contractEntity);
    }

    @ParaNotNull(ParaName = {"projectName:工程名称不能为空","stationId:请选择站点",
            "constructionUnit:施工单位不能为空","pourPart:浇筑部位不能为空"})
    @RequestMapping(value="/saveAndSubmit",method = RequestMethod.POST)
    public Result saveAndSubmit(@RequestBody ContractEntity contractEntity){
        contractEntity.setStatus(1);
        contractEntity.setCreateUser(UserAgent.getAccount());
        contractEntity.setCreateUserName(UserAgent.getUsername());
        contractEntity.setCreateTime(Instant.now());
        contractService.save(contractEntity);
        return new Result(contractEntity);
    }

    @ParaNotNull(ParaName = {"projectName:工程名称不能为空","stationId:请选择站点",
            "constructionUnit:施工单位不能为空","pourPart:浇筑部位不能为空"})
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Result update(@RequestBody ContractEntity contractEntity){
        contractEntity.setContractCode("");
        contractEntity.setCreateUser("");
        contractEntity.setCreateUserName("");
        contractEntity.setCreateTime(null);

        contractEntity.setModifyUser(UserAgent.getAccount());
        contractEntity.setModifyTime(Instant.now());

        int i = contractService.update(contractEntity);
        return new Result(i);
    }

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public Result submit(@RequestBody Long[] ids){
        List list = Arrays.asList(ids);
        for(Long id : ids){
            ContractEntity contractEntity = contractService.queryById(id);

            if(StringUtils.isEmpty(contractEntity.getProjectName())){
                return new Result("合同编号：" + contractEntity.getContractCode() +",工程名称不能为空");
            }

            if(StringUtils.isEmpty(contractEntity.getStationId())){
                return new Result("合同编号：" + contractEntity.getContractCode() + ",站点不能为空");
            }

            if(StringUtils.isEmpty(contractEntity.getConstructionUnit())){
                return new Result("合同编号：" + contractEntity.getContractCode() + ",施工单位不能为空");
            }

            if(StringUtils.isEmpty(contractEntity.getAccountingUnit())){
                return new Result("合同编号：" + contractEntity.getContractCode() + ",核算单位不能为空");
            }

            if(StringUtils.isEmpty(contractEntity.getAccountingUnit())){
                return new Result("合同编号：" + contractEntity.getContractType() + ",合同类型不能为空");
            }

        }
        int i = contractService.submit(list);
        return new Result(i);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(@RequestBody Long[] ids){
        List list = Arrays.asList(ids);
        for(Long id : ids){
            ContractEntity contractEntity = contractService.queryById(id);
            if(contractEntity.getStatus() == 1){
                return new Result("合同编号：" + contractEntity.getContractCode() +",数据已提交，不能删除");
            }
        }
        int i = contractService.delete(list);
        return new Result(i);
    }

    @RequestMapping(value = "/importProject",method = RequestMethod.POST)
    public Result importProject(@RequestBody List<ContractEntity> list){
        List<ProjectEntity> listProject = new ArrayList <>();
        //查找数据库中的最大值
        Integer maxCode = projectService.queryForMaxCode();
        for(ContractEntity contractEntity : list){
            if(contractEntity.getStatus() == 0){
                return new Result("合同编号：" + contractEntity.getContractCode() +",数据未提交，不能导入工程");
            }

            int count = projectService.queryByContractId(contractEntity.getId());
            if(count > 0 ){
                return new Result("合同编号：" + contractEntity.getContractCode() +",已导入工程，不能多次导入");
            }

            String projectCode = "P" + LocalDate.now().toString().replace("-", "");

            //生成projectCode
            if(StringUtils.isEmpty(maxCode)){
                maxCode =1;
            }else{
                maxCode = maxCode +1;
            }

            projectCode =projectCode + String.format("%04d", maxCode);

            ProjectEntity projectEntity = new ProjectEntity();
            projectEntity.setContractId(contractEntity.getId());
            projectEntity.setContractCode(contractEntity.getContractCode());
            projectEntity.setProjectCode(projectCode);
            projectEntity.setProjectName(contractEntity.getProjectName());


//            projectEntity.setConstructionUnit(contractEntity.getConstructionUnit());
//            projectEntity.setAccountingUnit(contractEntity.getAccountingUnit());
//            projectEntity.setConstructionPlace(contractEntity.getConstructionPlace());
//            projectEntity.setLiaisonPerson(contractEntity.getLiaisonPerson());
//            projectEntity.setTelephone(contractEntity.getTelephone());
//            projectEntity.setConcreteQuantity(contractEntity.getConcreteQuantity());
//            projectEntity.setTechnicalRequirement(contractEntity.getTechnicalRequirement());


            projectEntity.setStatus(0);
            projectEntity.setCreateUser(UserAgent.getAccount());
            projectEntity.setCreateUserName(UserAgent.getUsername());
            projectEntity.setCreateTime(Instant.now());

            listProject.add(projectEntity);
        }

         //批量插入工程表
        int i = projectService.saveBatch(listProject);
        return new Result(i);
    }


}
