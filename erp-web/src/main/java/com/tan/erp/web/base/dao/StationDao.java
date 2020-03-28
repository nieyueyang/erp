package com.tan.erp.web.base.dao;

import com.tan.erp.web.base.entity.StationEntity;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/18 18:08
 * @Version 1.0
 * @Description:
 */
@Repository
public class StationDao {

    @Autowired
    private SqlSession sqlSessionTemplate;

    public List <StationEntity> queryForList(StationEntity stationEntity){
        return sqlSessionTemplate.selectList("com.station.queryForList",stationEntity);
    }

}
