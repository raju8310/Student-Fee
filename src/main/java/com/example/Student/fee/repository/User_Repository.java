package com.example.Student.fee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Student.fee.entity.User;

public interface User_Repository extends JpaRepository<User, Long> {
	 User findByFirstName(String firstName);

}
