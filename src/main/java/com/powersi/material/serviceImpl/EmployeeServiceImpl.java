package com.powersi.material.serviceImpl;

import com.powersi.material.mapper.EmployeeMapper;
import com.powersi.material.pojo.Employee;
import com.powersi.material.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employees = employeeMapper.selectByExample(null);
        return employees;
    }

    @Override
    public Employee findEmpById(String id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateEmp(Employee employee) {

        employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public void addEmp(Employee employee) {
        employee.setEmpJoinDate(new Date());
        employeeMapper.insert(employee);



    }

    @Override
    public void deleteEmpById(String id) {

        employeeMapper.deleteByPrimaryKey(id);
    }
}
