package com.example.Student.fee.entity;

import org.jspecify.annotations.Nullable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
@Table(name="students")
public class Student {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  	@NotNull(message = "First name cannot be null")
	    private String firstName;
	    @NotNull(message = "Last name cannot be null")
	    private String lastName;
	    @NotNull(message = "Department cannot be null")
	    private String department;
//	    @NotBlank(message = "Year cannot be blank")
	    private String year;

	    private String gender;

	    private String place;

	    @Column(unique = true)
	    private String email;

	    private String phone;
	    @NotNull(message = "Total Fee is required")
	    @Positive(message = "Total Fee must be greater than 0")
	    private Double totalFee;

	    private Double paidFee;

	    private Double balanceFee;
	    
	    private String Password;
		

	
}
