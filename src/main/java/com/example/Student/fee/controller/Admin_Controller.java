package com.example.Student.fee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Student.fee.entity.Student;
import com.example.Student.fee.service.StudentsService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class Admin_Controller {
	
	
	private final StudentsService studentsService;
	
	public Admin_Controller(StudentsService studentsService) {
		this.studentsService = studentsService;
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("students", studentsService.getAllStudents());
		return "admin-dashboard";
		
	}
	@GetMapping("/add")
	public String addStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "student-form";
	}
	
	@PostMapping("/save")
	public String saveStudent( @Valid @ModelAttribute Student student ,BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "student-form";
		}
		studentsService.saveStudent(student);
		return "redirect:/admin/dashboard";
	}
	
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable Long id,Model model) {
		model.addAttribute("student", studentsService.getStudentById(id));
		return "student-form";
	}
	
	@PostMapping("/update")
	public String updateStudent(@ModelAttribute Student student) {
		studentsService.updateStudent(student);
		return "redirect:/admin/dashboard";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentsService.deleteStudent(id);
		return "redirect:/admin/dashboard";
	}
	
	@GetMapping("/search")
	public String serachStudent(@RequestParam("name") String name,Model model) {
		model.addAttribute("students", studentsService.searchStudent(name));
		return "admin-dashboard";
	}

}
