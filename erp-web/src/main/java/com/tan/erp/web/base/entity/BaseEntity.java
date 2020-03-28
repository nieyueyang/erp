package com.tan.erp.web.base.entity;

/**
 * @Author: nieyy
 * @Date: 2020/3/14 1:20
 * @Version 1.0
 * @Description:
 */
public class BaseEntity {
    private Integer pageNum;
    private Integer pageSize;
    private String sidx;
    private String sord;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }


}
