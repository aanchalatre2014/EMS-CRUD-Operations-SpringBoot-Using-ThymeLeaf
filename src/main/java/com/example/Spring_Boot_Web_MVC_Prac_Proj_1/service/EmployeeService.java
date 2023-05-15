package com.example.Spring_Boot_Web_MVC_Prac_Proj_1.service;
import com.example.Spring_Boot_Web_MVC_Prac_Proj_1.model.Employee;
import com.example.Spring_Boot_Web_MVC_Prac_Proj_1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;

    public List<Employee> getAllEmployees() {

        return repository.findAll();// it will fetch all the records of employees
    }

    public void add(Employee employee) {

        repository.save(employee); // this will add the employee record in the table
    }
    public Employee getEmployeeById(long id){
        Optional<Employee> optional= repository.findById(id);
        Employee employee=optional.get();
        return employee;
    }
    public void deleteEmployee(Long id){
        repository.deleteById(id); // Delete specific record..

    }
}