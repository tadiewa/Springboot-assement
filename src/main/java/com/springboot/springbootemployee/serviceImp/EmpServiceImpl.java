package com.springboot.springbootemployee.serviceImp;

import com.springboot.springbootemployee.Exception.ResnotfoundExpt;
import com.springboot.springbootemployee.Model.Employee;
import com.springboot.springbootemployee.Repository.EmpRepository;
import com.springboot.springbootemployee.service.EmpService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl  implements EmpService {
     private EmpRepository employeeRepository;

    public EmpServiceImpl(EmpRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
       //Optional <Employee> employee = employeeRepository.findById(id);
        return employeeRepository.findById(id).orElseThrow(()->
                new ResnotfoundExpt("Employee","id",id));
    }

    @Override
    public Employee getEmployeeByFirstName(String name) {
        return employeeRepository.findEmployeeByFirstName(name).orElseThrow(()->
                new ResnotfoundExpt("Employee","FirstName",name));
    }

    @Override
    public Employee getEmployeeByLastName(String lname) {
        return employeeRepository.findEmployeeByLastName(lname).orElseThrow(()->
                new ResnotfoundExpt("Employee","LastName",lname));
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        // check if the employee with id is in db or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->
                new ResnotfoundExpt("Employee","id",id));
        // updating employee
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setJobTitle(employee.getJobTitle());
        existingEmployee.setDob(employee.getDob());
        existingEmployee.setCreateStamp(employee.getCreateStamp());

        // save existing emp to db
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        // check existance of employee in db
        employeeRepository.findById(id).orElseThrow(()->
                new ResnotfoundExpt("Employee","id",id));
        employeeRepository.deleteById(id);

    }


}
