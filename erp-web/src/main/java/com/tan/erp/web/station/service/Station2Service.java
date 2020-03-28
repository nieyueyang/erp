package com.tan.erp.web.station.service;

import com.tan.erp.mybatis.annotation.TargetColumn;
import com.tan.erp.mybatis.annotation.TargetTable;
import com.tan.erp.web.station.dao.Station2Dao;
import com.tan.erp.web.station.entity.QueryParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: nieyy
 * @Date: 2020/3/6 21:33
 * @Version 1.0
 * @Description:
 */
@Service
public class Station2Service {

    @Autowired
    private Station2Dao station2Dao;

    public <T> int insert(T t) throws Exception {
        Class <?> clazz = t.getClass();
        String targetTable = getTableName(t.getClass());
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder insertInto = new StringBuilder();
        insertInto.append("insert into ").append(targetTable).append("(");
        StringBuilder values = new StringBuilder();
        values.append("values(");
        int i = 0;
        for (Field field : fields) {
            String aa = field.getName();
            if (field.isAnnotationPresent(TargetColumn.class)) {
                String column = field.getAnnotation(TargetColumn.class).value();
                field.setAccessible(true);
                Object obj = field.get(t);
                Class type = field.getType();

                //处理日期类型
                if (type == LocalDate.class) {
                    obj = java.sql.Date.valueOf((LocalDate) field.get(t));
                } else if (type == LocalDateTime.class) {
                    LocalDateTime localDateTime = (LocalDateTime) field.get(t);
                    obj = java.sql.Timestamp.valueOf(localDateTime);
                } else if (type == Instant.class) {
                    obj = java.sql.Timestamp.from((Instant) field.get(t));
                }

                if (obj != null && !StringUtils.isEmpty(column)) {
                    if (i == 0) {
                        insertInto.append(column);
                        values.append("'").append(obj).append("'");
                    } else {
                        insertInto.append(",").append(column);
                        values.append(",").append("'").append(obj).append("'");
                    }
                    i++;
                }

            }
        }

        insertInto.append(")");
        values.append(")");
        insertInto.append(values);
        return station2Dao.insert(insertInto.toString());
    }

    public <T> List <T> select(T t, List <QueryParameters> list) throws Exception {
        Class <?> clazz = t.getClass();
        String tableName = getTableName(clazz);
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder select = new StringBuilder();
        select.append("select ");
        StringBuilder where = new StringBuilder();
        int i = 0;
        for (Field field : fields) {
            if (field.isAnnotationPresent(TargetColumn.class)) {
                //field.setAccessible(true);
                //Object obj = field.get(t);
                String column = field.getAnnotation(TargetColumn.class).value();
                if (i == 0) {
                    select.append(column);
//                    if(obj != null){
//                        where.append(column).append("=").append("'").append(obj).append("'");
//                    }

                } else {
                    select.append(",").append(column);
//                    if(obj != null){
//                        where.append(" and ").append(column).append("=").append("'").append(obj).append("'");
//                    }
                }
                i++;
            }
        }

        int size = list.size();
        for (int j = 0; j < size; j++) {
            QueryParameters query = list.get(j);
            if (j == 0) {
                where.append(" where ").append(query.getColumnName()).append(query.getOperator()).append("'").append(query.getValue()).append("'");
            } else {
                where.append(" and ").append(query.getColumnName()).append(query.getOperator()).append("'").append(query.getValue()).append("'");
            }

        }

        select.append(" from ").append(tableName).append(" ");
//        if(where.toString().length() > 7){
//            select.append(where);
//        }
        select.append(where);
        return station2Dao.select(select.toString());
    }


    private String getTableName(Class <?> clazz) throws Exception {

        if (clazz.isAnnotationPresent(TargetTable.class)) {
            return clazz.getAnnotation(TargetTable.class).value();
        } else {
            throw new Exception("实体类" + clazz.getName() + "中没有配置Table注解");
        }

    }


}
