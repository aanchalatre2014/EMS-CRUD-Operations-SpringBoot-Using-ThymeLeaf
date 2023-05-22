package com.example.Spring_Boot_Web_MVC_Prac_Proj_1.repository;

import com.example.Spring_Boot_Web_MVC_Prac_Proj_1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
