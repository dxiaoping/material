package com.powersi.material.service;

import com.powersi.material.pojo.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> findAllEmployees();

    public Employee findEmpById(String id);

    public void updateEmp(Employee employee);

    public void addEmp(Employee employee);

    public void deleteEmpById(String id);




}
