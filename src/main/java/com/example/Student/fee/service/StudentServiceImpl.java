package com.example.Student.fee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Student.fee.entity.Student;
import com.example.Student.fee.repository.Student_Repository;

@Service
public class StudentServiceImpl  implements StudentsService {
	
	private final Student_Repository student_Repository ;
	
	public StudentServiceImpl(Student_Repository student_Repository) {
	    this.student_Repository = student_Repository;
	}

	@Override
	public Student saveStudent(Student student) {
		 student.setBalanceFee(student.getTotalFee() - student.getPaidFee());

	        return student_Repository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return student_Repository.findAll();
	
	}

	@Override
	public Student getStudentById(Long id) {
        return student_Repository.findById(id).orElse(null);
	}

	@Override
	public Student updateStudent(Student student) {
		
		student.setBalanceFee(student.getTotalFee() - student.getPaidFee());

        return student_Repository.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		student_Repository.deleteById(id);
	}

	@Override
	public Student searchStudent(String firstName) {
        return student_Repository.findByFirstName(firstName);
	}



	@Override
	public Object getStudentByFirstName(String firstName) {
		return student_Repository.findByFirstName(firstName);
	}
}


	
	

