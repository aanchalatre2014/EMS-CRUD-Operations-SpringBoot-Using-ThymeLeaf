package com.example.Spring_Boot_Web_MVC_Prac_Proj_1.controller;

import com.example.Spring_Boot_Web_MVC_Prac_Proj_1.model.Employee;
import com.example.Spring_Boot_Web_MVC_Prac_Proj_1.service.EmployeeService;
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
public class EmployeeController {
    @Autowired
    EmployeeService service;
    @GetMapping("/")
    public String viewHomePage(Model model){
        return findPaginated(1, model);
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
    //Pagination..
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Employee> page = service.findPaginated(pageNo, pageSize);
        List<Employee> listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listEmployees", listEmployees);
        return "index";
    }

}
