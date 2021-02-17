package com.kinishinai.kyummybackend.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    @Column(length = 16)
	private UUID id;
	private String region;
	private String province;
	private String city;
	private String barangay;
	private String postalCode;
	private String detailedAddress;
	//TODO: remember userId
	@Column(length = 16)
	private UUID userId;
	private boolean youWantItToBeDefault;
	
	
	
	
}
