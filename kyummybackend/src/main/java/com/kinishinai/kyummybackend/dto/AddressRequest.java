package com.kinishinai.kyummybackend.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
	private String region;
	private String province;
	private String city;
	private String barangay;
	private String postalCode;
	private String detailedAddress;
	//TODO: remember userId
	private UUID userId;
	private boolean youWantItToBeDefault;
	
}
