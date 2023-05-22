package com.example.Spring_Boot_Web_MVC_Prac_Proj_1.service;

import com.example.Spring_Boot_Web_MVC_Prac_Proj_1.model.Employee;
import com.example.Spring_Boot_Web_MVC_Prac_Proj_1.model.Student;
import com.example.Spring_Boot_Web_MVC_Prac_Proj_1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> getAllStudents() {

        return repository.findAll();// it will fetch all the records of students
    }
    public void add(Student student) {

        repository.save(student); // this will add student record in the table
    }
    //update student
    public Student getStudentById(long id){
        Optional<Student> optional= repository.findById(id);
        Student student=optional.get();
        return student;
    }
    //Delete student
    public void deleteStudent(Long id){
        repository.deleteById(id); // Delete specific record..

    }

    //Pagination
    public Page<Student> findPaginated(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return repository.findAll(pageable);
    }

}
