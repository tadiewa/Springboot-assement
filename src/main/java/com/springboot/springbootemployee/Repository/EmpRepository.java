package com.springboot.springbootemployee.Repository;

import com.springboot.springbootemployee.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findEmployeeByFirstName(String name);

    Optional<Employee> findEmployeeByLastName(String name);

}
