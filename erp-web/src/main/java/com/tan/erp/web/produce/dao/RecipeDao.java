package com.tan.erp.web.produce.dao;

import com.tan.erp.web.produce.entity.ContractEntity;
import com.tan.erp.web.produce.entity.RecipeEntity;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/28 23:48
 * @Version 1.0
 * @Description:
 */
@Repository
public class RecipeDao {

    @Autowired
    private SqlSession sqlSessionTemplate;

    public List <RecipeEntity> queryForList(RecipeEntity recipeEntity){
        return sqlSessionTemplate.selectList("com.recipe.selectForList",recipeEntity);
    }

    public Integer queryForMaxCode(){
        return sqlSessionTemplate.selectOne("com.recipe.selectForMaxCode");
    }

    public List<RecipeEntity> selectForIds(List<Long> list){
        return sqlSessionTemplate.selectList("com.recipe.selectForIds",list);
    }

    public RecipeEntity save(RecipeEntity recipeEntity){
        sqlSessionTemplate.insert("com.recipe.insert",recipeEntity);
        return recipeEntity;
    }

    public int update(RecipeEntity recipeEntity){
        return sqlSessionTemplate.update("com.recipe.updateByPrimaryKey",recipeEntity);
    }

    public int updateForImport(long id){
        return sqlSessionTemplate.update("com.recipe.updateForImport",id);
    }

    public int delete(List<Long> list){
        return sqlSessionTemplate.delete("com.recipe.deleteByPrimaryKey",list);
    }



}
