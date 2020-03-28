package com.tan.erp.web.produce.dao;

import com.tan.erp.web.produce.entity.ContractEntity;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/17 23:50
 * @Version 1.0
 * @Description:
 */
@Repository
public class ContractDao {

    @Autowired
    private SqlSession sqlSessionTemplate;

    public List<ContractEntity> queryForList(ContractEntity contractEntity){
        return sqlSessionTemplate.selectList("com.contract.selectForList",contractEntity);
    }

    public ContractEntity queryById(Long id){
        return sqlSessionTemplate.selectOne("com.contract.selectByPrimaryKey",id);
    }

    public Integer queryForMaxCode(){
        return sqlSessionTemplate.selectOne("com.contract.selectForMaxCode");
    }

    public List<ContractEntity> queryNotImport(ContractEntity contractEntity){
        return sqlSessionTemplate.selectList("com.contract.selectNotImport",contractEntity);
    }

    public ContractEntity save(ContractEntity contractEntity){
        sqlSessionTemplate.insert("com.contract.insert",contractEntity);
        return contractEntity;
    }

    public int update(ContractEntity contractEntity){
        return sqlSessionTemplate.update("com.contract.updateByPrimaryKey",contractEntity);
    }

    public int submit(List<Long> list){
        return sqlSessionTemplate.update("com.contract.submit",list);
    }

    public int delete(List<Long> list){
        return sqlSessionTemplate.delete("com.contract.delete",list);
    }

    public int importProject(Long[] ids){
        return sqlSessionTemplate.insert("",ids);
    }



}
