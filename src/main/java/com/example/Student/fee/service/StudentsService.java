package com.example.Student.fee.service;


import java.util.List;

import com.example.Student.fee.entity.Student;

public interface StudentsService {

	

    public Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudent(Long id);

    Student searchStudent(String firstName);
    
    public Object getStudentByFirstName(String firstName);
    
}
