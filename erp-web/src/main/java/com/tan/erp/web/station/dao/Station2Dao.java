package com.tan.erp.web.station.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: nieyy
 * @Date: 2020/3/6 23:25
 * @Version 1.0
 * @Description:
 */
@Repository
public class Station2Dao {

    @Autowired
    private SqlSession sqlSessionStation;

    public int insert(String sql) throws SQLException {
        Map map = new HashMap <>();
        map.put("sql", sql);
        return sqlSessionStation.insert("com.station2.insert", map);
    }

    public List select(String sql) throws SQLException {
        Map map = new HashMap <>();
        map.put("sql", sql);
        return sqlSessionStation.selectList("com.station2.select", map);
    }


}
