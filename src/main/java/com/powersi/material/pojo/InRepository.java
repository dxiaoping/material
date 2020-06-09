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
        this.id = id == null ? null : id.trim();
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId == null ? null : receiveId.trim();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
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