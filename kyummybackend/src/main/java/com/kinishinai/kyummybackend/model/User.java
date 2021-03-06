package com.kinishinai.kyummybackend.model;




import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="kyummy_users")
public class User {
	@Id
	@GeneratedValue
	@Column(length = 16)
	private UUID id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean isVerified;
	private String phoneNumber;
	private Instant dateCreated;
	private String gender;
	private String birthday;



	

	
	
	
}
