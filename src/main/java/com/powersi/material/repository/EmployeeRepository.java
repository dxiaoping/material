package com.powersi.material.repository;

import com.powersi.material.pojo.Employee;
import com.powersi.material.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findByIdAndEmpTelp(String id,String empTelp);


}
