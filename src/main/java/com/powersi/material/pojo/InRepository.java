package com.powersi.material.pojo;

import java.util.Date;

public class InRepository {
    private String id;

    private String receiveId;

    private String employeeId;

    private Date inRepoDate;

    private Integer inRepoState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getInRepoDate() {
        return inRepoDate;
    }

    public void setInRepoDate(Date inRepoDate) {
        this.inRepoDate = inRepoDate;
    }

    public Integer getInRepoState() {
        return inRepoState;
    }

    public void setInRepoState(Integer inRepoState) {
        this.inRepoState = inRepoState;
    }
}