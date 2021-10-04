package com.springboot.springbootemployee.Controller;

import com.springboot.springbootemployee.Model.Employee;
import com.springboot.springbootemployee.service.EmpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmpService  employeeservice;

    public EmployeeController(EmpService employeeservice) {
        this.employeeservice = employeeservice;
    }

    // build create employee Rest ApI
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeservice.saveEmployee(employee), HttpStatus.CREATED);
    }
    // build get all employee Rest Api
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeservice.getAllEmployee();

    }
    // get employee by id rest api
    //api/employees/id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId){
        return new ResponseEntity<Employee>(employeeservice.getEmployeeById(employeeId),HttpStatus.OK);
    }
    // get employee by firstname
    //api/employee/name
    @GetMapping("firstname/{name}")
    public ResponseEntity<Employee> getEmployeeByFirstName(@PathVariable("name") String employeename){
        return new ResponseEntity<Employee>(employeeservice.getEmployeeByFirstName(employeename),HttpStatus.OK);
    }
    // get employee by lastname
    //api/employee/lname
   @GetMapping("lastname/{name}")
   public ResponseEntity<Employee> getEmployeeByLastName(@PathVariable("name") String employeelastname){
       return new ResponseEntity<Employee>(employeeservice.getEmployeeByLastName(employeelastname),HttpStatus.OK);
    }
    // build update rest api
    //api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable("id") long id
                                                                     ,@RequestBody Employee employee //storing the updated employee in an object Employee employee returned as json use the @Requestbody to convert it to java object
    ){
        return new ResponseEntity<Employee>(employeeservice.updateEmployee(employee,id), HttpStatus.OK);
    }
    // build delete employee rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("id") long id){
        // calling delete of employeeservice  to delete the employee
        employeeservice.deleteEmployee(id);

        // return success
        return new ResponseEntity<String>("Employee deleted  successfully.",HttpStatus.OK);
    }
}
