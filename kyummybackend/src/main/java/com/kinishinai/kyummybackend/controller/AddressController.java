package com.kinishinai.kyummybackend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kinishinai.kyummybackend.dto.AddressRequest;
import com.kinishinai.kyummybackend.model.Address;
import com.kinishinai.kyummybackend.service.AddressService;

@RestController
@RequestMapping("/kyummy/auth")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	
	@PostMapping("/address")
	public ResponseEntity<String> registerAddress(@RequestBody AddressRequest addressRequest){
		 addressService.registerAddress(addressRequest);
		 return new ResponseEntity<>("address register successfully", HttpStatus.OK);
	}
	
	@GetMapping("/address/{addressId}/get")
	public Address getUserSpecificAddress(@PathVariable UUID addressId){
		return addressService.getSpecificAddress(addressId);
		
	}
	
	@GetMapping("/address/{userId}")
	public List<Address> getAddressOfTheUser(@PathVariable UUID userId) {
		return addressService.getAddressOfTheUser(userId);
	}
	
	@PutMapping("/address/{addressId}/update")
	public ResponseEntity<String> updateUserAddress(@RequestBody AddressRequest addressRequest, @PathVariable UUID addressId){
		addressService.updateAddress(addressRequest, addressId);
		return new ResponseEntity<>("SuccessFully updated", HttpStatus.OK);
	}
	
	@DeleteMapping("/address/{addressId}/delete")
	public ResponseEntity<String> deleteUserAddress(@PathVariable UUID addressId){
		addressService.deleteAddress(addressId);
		return new ResponseEntity<>("Successfully deleted", HttpStatus.NO_CONTENT);
	}
	

	
	
}
