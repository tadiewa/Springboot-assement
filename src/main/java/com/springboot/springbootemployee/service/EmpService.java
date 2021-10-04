package com.springboot.springbootemployee.service;

import com.springboot.springbootemployee.Model.Employee;

import java.util.List;

public interface EmpService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Long id);
    Employee getEmployeeByFirstName(String name);
    Employee getEmployeeByLastName(String lname);
    Employee updateEmployee(Employee employee ,Long id);
    void deleteEmployee(long id);
}
