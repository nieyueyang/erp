package com.tan.erp.web.produce.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tan.erp.web.produce.dao.RecipeDao;
import com.tan.erp.web.produce.entity.ContractEntity;
import com.tan.erp.web.produce.entity.RecipeEntity;
import com.tan.erp.web.station.service.Station2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/7 22:08
 * @Version 1.0
 * @Description:
 */
@Service
public class RecipeService {

    @Autowired
    private RecipeDao recipeDao;
    @Autowired
    private Station2Service station2Service;

    public PageInfo<RecipeEntity> queryForPage(RecipeEntity recipeEntity){
        String orderby = "";
        String sidx = recipeEntity.getSidx();
        if (!StringUtils.isEmpty(sidx)) {
            String sord = recipeEntity.getSord();
            orderby = sidx + " " + sord;
        }
        PageHelper.startPage(recipeEntity.getPageNum(), recipeEntity.getPageSize(), orderby);
        List<RecipeEntity> list = recipeDao.queryForList(recipeEntity);
        PageInfo <RecipeEntity> PageUser = new PageInfo <>(list);
        return PageUser;
    }

    public List<RecipeEntity> selectForIds(List<Long> list){
        return recipeDao.selectForIds(list);
    }

    public RecipeEntity save(RecipeEntity recipeEntity){
        String recipeCode = recipeEntity.getRecipeCode();
        if(StringUtils.isEmpty(recipeCode)){
            recipeCode = "R" + LocalDate.now().toString().replace("-", "");
            Integer maxCode = recipeDao.queryForMaxCode();
            if(StringUtils.isEmpty(maxCode)){
                recipeCode = recipeCode + String.format("%04d", 1);
            }else{
                recipeCode = recipeCode + String.format("%04d", maxCode + 1);
            }
        }

        recipeEntity.setRecipeCode(recipeCode);
        return recipeDao.save(recipeEntity);
    }

    public int update(RecipeEntity recipeEntity){
        return recipeDao.update(recipeEntity);
    }

    public int delete(List<Long> list){
        return recipeDao.delete(list);
    }


    @Transactional
    public int importMixingPlant(List<Long> list) throws Exception {
        List<RecipeEntity> recipeList = selectForIds(list);
        for(RecipeEntity recipeEntity : recipeList){
            if(recipeEntity.getImportFlag() !=1 ){
                station2Service.insert(recipeEntity);
                recipeDao.updateForImport(recipeEntity.getId());
            }
        }
        return recipeList.size();
    }



}
