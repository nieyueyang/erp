package com.tan.erp.web.station.entity;

/**
 * @Author: nieyy
 * @Date: 2020/3/8 12:06
 * @Version 1.0
 * @Description:
 */

public class QueryParameters {

    private String columnName;
    private String operator;
    private Object value;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }


}
