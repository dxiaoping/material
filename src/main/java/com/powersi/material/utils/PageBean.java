package com.powersi.material.utils;

import java.util.List;
//自己写的pageBean,思路：因为又要传分页集合又要传总记录数所以封装成一个组合类，总记录数目的：前端需要确定总记录数来根据数据的不同动态展示页数
public class PageBean {
    private  Integer total;
    private List pagedList;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List getPagedList() {
        return pagedList;
    }

    public void setPagedList(List pagedList) {
        this.pagedList = pagedList;
    }
}
