package com.powersi.material.controller;

import com.powersi.material.pojo.Employee;
import com.powersi.material.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/emp")
@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/findAllEmp")
    public List<Employee> findAllEmp(){
       return employeeService.findAllEmployees();
    }

    @RequestMapping("/findEmpById")
    public Employee findEmpById(String id){
        return employeeService.findEmpById(id);
    }

    @RequestMapping("/updateEmp")
    public void updateEmp(Employee employee){
        employeeService.updateEmp(employee);
    }

    @RequestMapping("/deleteEmpById")
    public void deleteEmpById(String id){
        employeeService.deleteEmpById(id);
    }


}
