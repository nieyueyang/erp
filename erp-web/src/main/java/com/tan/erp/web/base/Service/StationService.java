package com.tan.erp.web.base.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tan.erp.web.base.dao.StationDao;
import com.tan.erp.web.base.entity.StationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/18 20:20
 * @Version 1.0
 * @Description:
 */
@Service
public class StationService {

    @Autowired
    private StationDao stationDao;

    public PageInfo<StationEntity> queryForPage(StationEntity stationEntity){
        String orderby = "";
        String sidx = stationEntity.getSidx();
        if (!StringUtils.isEmpty(sidx)) {
            String sord = stationEntity.getSord();
            orderby = sidx + " " + sord;
        }
        PageHelper.startPage(stationEntity.getPageNum(), stationEntity.getPageSize(), orderby);
        List<StationEntity> list = stationDao.queryForList(stationEntity);
        PageInfo <StationEntity> PageUser = new PageInfo <>(list);
        return PageUser;
    }

    public List<StationEntity> queryForList(StationEntity stationEntity){
        return stationDao.queryForList(stationEntity);
    }



}
