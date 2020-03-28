package com.tan.erp.web.produce.service;

import com.tan.erp.web.produce.entity.RecipeEntity;
import com.tan.erp.web.station.service.Station2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: nieyy
 * @Date: 2020/3/7 22:08
 * @Version 1.0
 * @Description:
 */
@Service
public class RecipeService {

    @Autowired
    private Station2Service station2Service;

    public int saveTostation(RecipeEntity recipeEntity) throws Exception {
        return station2Service.insert(recipeEntity);
    }

}
