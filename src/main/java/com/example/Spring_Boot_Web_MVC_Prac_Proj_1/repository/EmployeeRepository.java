package com.example.Spring_Boot_Web_MVC_Prac_Proj_1.repository;

import com.example.Spring_Boot_Web_MVC_Prac_Proj_1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {

}
