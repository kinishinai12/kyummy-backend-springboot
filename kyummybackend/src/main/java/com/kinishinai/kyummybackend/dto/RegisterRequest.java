package com.kinishinai.kyummybackend.dto;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;

import com.kinishinai.kyummybackend.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	private String gender;
	private String birthday;
		
	
}
