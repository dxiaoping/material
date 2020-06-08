package com.powersi.material.pojo;

import java.util.Date;

public class Employee {
    private String id;

    private String empName;

    private String empSex;

    private Date empBirthday;

    private String empRole;

    private String empTelp;

    private Date empJoinDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public Date getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(Date empBirthday) {
        this.empBirthday = empBirthday;
    }

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }

    public String getEmpTelp() {
        return empTelp;
    }

    public void setEmpTelp(String empTelp) {
        this.empTelp = empTelp;
    }

    public Date getEmpJoinDate() {
        return empJoinDate;
    }

    public void setEmpJoinDate(Date empJoinDate) {
        this.empJoinDate = empJoinDate;
    }
}