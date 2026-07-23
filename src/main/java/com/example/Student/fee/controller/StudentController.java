package com.example.Student.fee.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Student.fee.entity.Student;
import com.example.Student.fee.entity.User;
import com.example.Student.fee.repository.Student_Repository;
import com.example.Student.fee.repository.User_Repository;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final User_Repository userRepository;
    private final Student_Repository studentRepository;


    public StudentController(User_Repository userRepository, Student_Repository studentRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }


    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {


        // Get logged-in username
        String username = authentication.getName();


        // Find user from database
       Student student = studentRepository.findByFirstName(username);


        // Get student linked with this user
        model.addAttribute("student", student);


        return "student-dashboard";
    }

}