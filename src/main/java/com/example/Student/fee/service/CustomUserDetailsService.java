package com.example.Student.fee.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Student.fee.entity.Student;
import com.example.Student.fee.entity.User;
import com.example.Student.fee.repository.Student_Repository;
import com.example.Student.fee.repository.User_Repository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final User_Repository userRepository;
    private final Student_Repository studentRepository;

    public CustomUserDetailsService(User_Repository userRepository,
    											Student_Repository studentRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String firstName)
            throws UsernameNotFoundException {


        User user = userRepository.findByFirstName(firstName);



        if(user!=null) {
        


        return org.springframework.security.core.userdetails.User
                .withUsername(user.getFirstName())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
        }
        
        Student student = studentRepository.findByFirstName(firstName);

        if (student != null) {
            return org.springframework.security.core.userdetails.User
                    .withUsername(student.getFirstName())
                    .password(student.getPassword())
                    .roles("STUDENT")
                    .build();
        }


        throw new UsernameNotFoundException("User not found");
    }
    
}