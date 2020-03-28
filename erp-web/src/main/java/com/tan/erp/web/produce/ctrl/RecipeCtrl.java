package com.tan.erp.web.produce.ctrl;

import com.tan.erp.common.dto.Result;
import com.tan.erp.web.produce.entity.RecipeEntity;
import com.tan.erp.web.produce.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * @Author: nieyy
 * @Date: 2020/3/7 22:05
 * @Version 1.0
 * @Description:
 */
@RestController
@RequestMapping("/pp/recipe")
public class RecipeCtrl {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/save")
    public Result save(@RequestBody RecipeEntity recipeEntity) throws Exception {
        recipeEntity.setCreateTime(Timestamp.from(Instant.now()));
        int i = recipeService.saveTostation(recipeEntity);
        return new Result(i);

    }


}
