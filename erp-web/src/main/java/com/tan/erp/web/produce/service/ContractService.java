package com.tan.erp.web.produce.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tan.erp.web.produce.dao.ContractDao;
import com.tan.erp.web.produce.entity.ContractEntity;
import com.tan.erp.web.produce.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/17 23:52
 * @Version 1.0
 * @Description:
 */
@Service
public class ContractService {

    @Autowired
    private ContractDao contractDao;

    public PageInfo<ContractEntity> queryForPage(ContractEntity contractEntity){
        String orderby = "";
        String sidx = contractEntity.getSidx();
        if (!StringUtils.isEmpty(sidx)) {
            String sord = contractEntity.getSord();
            orderby = sidx + " " + sord;
        }
        PageHelper.startPage(contractEntity.getPageNum(), contractEntity.getPageSize(), orderby);
        List<ContractEntity> list = contractDao.queryForList(contractEntity);
        PageInfo <ContractEntity> PageUser = new PageInfo <>(list);
        return PageUser;
    }

    public ContractEntity queryById(Long id){
        return contractDao.queryById(id);
    }

    public PageInfo<ContractEntity> queryNotImport(ContractEntity contractEntity){
        String orderby = "";
        String sidx = contractEntity.getSidx();
        if (!StringUtils.isEmpty(sidx)) {
            String sord = contractEntity.getSord();
            orderby = sidx + " " + sord;
        }
        PageHelper.startPage(contractEntity.getPageNum(), contractEntity.getPageSize(), orderby);
        List<ContractEntity> list = contractDao.queryNotImport(contractEntity);
        PageInfo <ContractEntity> PageUser = new PageInfo <>(list);
        return PageUser;
    }

    public ContractEntity save(ContractEntity contractEntity){
        String contractCode = "C" + LocalDate.now().toString().replace("-", "");
        Integer maxCode = contractDao.queryForMaxCode();

        if(StringUtils.isEmpty(maxCode)){
            contractCode =contractCode + String.format("%04d", 1);
        }else{
            contractCode =contractCode + String.format("%04d", maxCode + 1);
        }

        contractEntity.setContractCode(contractCode);
        return contractDao.save(contractEntity);
    }

    public int update(ContractEntity contractEntity){
        return contractDao.update(contractEntity);
    }

    public int submit(List<Long> list){
        return contractDao.submit(list);
    }

    public int delete(List<Long> list){
        return contractDao.delete(list);
    }



}
