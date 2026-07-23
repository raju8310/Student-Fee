package com.example.Student.fee.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Student.fee.entity.Student;

@Repository
public interface Student_Repository extends JpaRepository<Student, Long> {
	Student findByFirstName(String firstName);

}
