package com.example.Spring_Boot_Web_MVC_Prac_Proj_1.controller;


import com.example.Spring_Boot_Web_MVC_Prac_Proj_1.model.Student;
import com.example.Spring_Boot_Web_MVC_Prac_Proj_1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/student")
    public String viewHomePage(Model model){
        return findPaginated(1, model);

    }
    @GetMapping("/addStudentForm")
    public String addStudentForm(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        return "new_student";
    }
    @PostMapping("/saveStudent")
    public String addstudent(@ModelAttribute("student")Student student){
        service.add(student);
        return "redirect:/student";

    }
    @GetMapping("/updateStudentForm/{id}")
    public String updateStudentForm(@PathVariable long id, Model model){
        Student student=service.getStudentById(id);
        model.addAttribute("student",student);
        return "update_student";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable long id) {
        this.service.deleteStudent(id);
        return "redirect:/student";
    }
    //Pagination..
    @GetMapping("/pages/{pageNum}")
    public String findPaginated(@PathVariable(value = "pageNum") int pageNum, Model model) {
        int pageSize = 5;

        Page<Student> page = service.findPaginated(pageNum, pageSize);
        List< Student > listStudents = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listStudents", listStudents);
        return "student";
    }


}
