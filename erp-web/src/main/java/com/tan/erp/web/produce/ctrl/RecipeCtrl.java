package com.tan.erp.web.produce.ctrl;

import com.github.pagehelper.PageInfo;
import com.tan.erp.common.annotation.ParaNotNull;
import com.tan.erp.common.dto.Result;
import com.tan.erp.web.produce.entity.RecipeEntity;
import com.tan.erp.web.produce.service.RecipeService;
import com.tan.erp.web.util.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/7 22:05
 * @Version 1.0
 * @Description:
 */
@RestController
@RequestMapping("produce/recipe")
public class RecipeCtrl {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value="/queryForPage",method = RequestMethod.GET)
    public Result queryForPage(RecipeEntity recipeEntity){
        if(StringUtils.isEmpty(recipeEntity.getPageNum())){
            recipeEntity.setPageNum(1);
        }

        if(StringUtils.isEmpty(recipeEntity.getPageSize())){
            recipeEntity.setPageSize(10);
        }
        recipeEntity.setDeleteFlag(0);
        PageInfo<RecipeEntity> page = recipeService.queryForPage(recipeEntity);
        return new Result(page);
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public Result save(@RequestBody RecipeEntity recipeEntity){
        recipeEntity.setDeleteFlag(0);
        recipeEntity.setStatus(0);
        recipeEntity.setDeleteFlag(0);
        recipeEntity.setImportFlag(0);
        recipeEntity.setCreateUser(UserAgent.getAccount());
        recipeEntity.setCreateUserName(UserAgent.getUsername());
        recipeEntity.setCreateTime(Instant.now());
        recipeService.save(recipeEntity);
        return new Result(recipeEntity);
    }

    @ParaNotNull(ParaName = {"recipeCode:配比编号不能为空","recipeName:配比名称不能为空"})
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Result update(@RequestBody RecipeEntity recipeEntity){

        recipeEntity.setModifyUser(UserAgent.getAccount());
        recipeEntity.setModifyTime(Instant.now());
        int i = recipeService.update(recipeEntity);
        return new Result(i);
    }

    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public Result delete(@RequestBody Long[] ids){
        List list = Arrays.asList(ids);
        int i = recipeService.delete(list);
        return new Result(i);
    }

    @PostMapping("/import")
    public Result importMixingPlant(@RequestBody Long[] ids) throws Exception {
        List list = Arrays.asList(ids);
        int i = recipeService.importMixingPlant(list);
        return new Result(i);
    }


}
