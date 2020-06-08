package com.powersi.material.pojo;

public class ItemClass {
    private Integer id;

    private Integer itemClassFather;

    private String itemClassName;

    private String itemClassDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemClassFather() {
        return itemClassFather;
    }

    public void setItemClassFather(Integer itemClassFather) {
        this.itemClassFather = itemClassFather;
    }

    public String getItemClassName() {
        return itemClassName;
    }

    public void setItemClassName(String itemClassName) {
        this.itemClassName = itemClassName;
    }

    public String getItemClassDesc() {
        return itemClassDesc;
    }

    public void setItemClassDesc(String itemClassDesc) {
        this.itemClassDesc = itemClassDesc;
    }
}