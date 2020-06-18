package com.powersi.material.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String empName;

    private String empSex;

//    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date empBirthday;

    private String empRole;

    private String empTelp;

//    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date empJoinDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex == null ? null : empSex.trim();
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
        this.empRole = empRole == null ? null : empRole.trim();
    }

    public String getEmpTelp() {
        return empTelp;
    }

    public void setEmpTelp(String empTelp) {
        this.empTelp = empTelp == null ? null : empTelp.trim();
    }

    public Date getEmpJoinDate() {
        return empJoinDate;
    }

    public void setEmpJoinDate(Date empJoinDate) {
        this.empJoinDate = empJoinDate;
    }
}