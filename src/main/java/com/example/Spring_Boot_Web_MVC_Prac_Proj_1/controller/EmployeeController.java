package com.example.Spring_Boot_Web_MVC_Prac_Proj_1.controller;

import com.example.Spring_Boot_Web_MVC_Prac_Proj_1.model.Employee;
import com.example.Spring_Boot_Web_MVC_Prac_Proj_1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService service;
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees",service.getAllEmployees());
        return "index";
    }
    @GetMapping("/addEmployeeForm")
    public String addEmployeeForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }
    @PostMapping("/saveEmployee")
    public String addEmployee(@ModelAttribute("employee")Employee employee){
        service.add(employee);
        return "redirect:/";

    }
    @GetMapping("/updateEmployeeForm/{id}")
    public String updateEmployeeForm(@PathVariable long id, Model model){
        Employee employee=service.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "update_employee";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable long id) {
        this.service.deleteEmployee(id);
        return "redirect:/";
    }

}
