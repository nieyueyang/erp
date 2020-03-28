package com.tan.erp.web.station.ctrl;

import com.tan.erp.common.dto.Result;
import com.tan.erp.web.produce.entity.RecipeEntity;
import com.tan.erp.web.produce.entity.TaskEntity;
import com.tan.erp.web.station.entity.QueryParameters;
import com.tan.erp.web.station.service.Station2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/4 22:05
 * @Version 1.0
 * @Description:
 */
@RestController
@RequestMapping("station/")
public class Station2Ctrl {

    @Autowired
    private Station2Service station2Service;

    @PostMapping("/insertToStation")
    public Result insertToStation(@RequestBody TaskEntity taskEntity) throws Exception {

        int i = station2Service.insert(taskEntity);
        return new Result(i);
    }

    @PostMapping("/select")
    public Result select(@RequestBody RecipeEntity recipeEntity) throws Exception {
        List query = new ArrayList();

        QueryParameters queryParameters = new QueryParameters();
        queryParameters.setColumnName("create_time");
        queryParameters.setOperator(">=");
        queryParameters.setValue("2020-03-08");

        query.add(queryParameters);

        QueryParameters queryParameters2 = new QueryParameters();
        queryParameters2.setColumnName("create_time");
        queryParameters2.setOperator("<=");
        queryParameters2.setValue("2020-03-9");

        query.add(queryParameters2);

        List list = station2Service.select(recipeEntity, query);
        return new Result(list);
    }


}
