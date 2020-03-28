package com.tan.erp.web.base.ctrl;

import com.github.pagehelper.PageInfo;
import com.tan.erp.common.annotation.ParaNotNull;
import com.tan.erp.common.dto.Result;
import com.tan.erp.web.base.Service.StationService;
import com.tan.erp.web.base.entity.StationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/18 20:24
 * @Version 1.0
 * @Description:
 */
@RestController
@RequestMapping("/base/station")
public class StationCtrl {

    @Autowired
    private StationService stationService;

    @RequestMapping(value="queryForPage", method = RequestMethod.GET)
    public Result queryForPage(StationEntity stationEntity){
        PageInfo<StationEntity> page = stationService.queryForPage(stationEntity);
        return new Result(page);
    }

    @RequestMapping(value="queryForList", method = RequestMethod.GET)
    public Result queryForList(StationEntity stationEntity){
        List <StationEntity> list = stationService.queryForList(stationEntity);
        return new Result(list);
    }

    @ParaNotNull(ParaName = {"stationName:站点名称不能为空"})
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public Result insert(StationEntity stationEntity){

        return new Result("");
    }



}
