package com.kinishinai.kyummybackend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kinishinai.kyummybackend.dto.AddressRequest;
import com.kinishinai.kyummybackend.model.Address;
import com.kinishinai.kyummybackend.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	@Transactional
	public void registerAddress(AddressRequest addressRequest) {
		Address address = new Address();
		address.setRegion(addressRequest.getRegion());
		address.setProvince(addressRequest.getProvince());
		address.setCity(addressRequest.getCity());
		address.setBarangay(addressRequest.getBarangay());
		address.setPostalCode(addressRequest.getPostalCode());
		address.setDetailedAddress(addressRequest.getDetailedAddress());
		address.setUserId(addressRequest.getUserId());
		address.setYouWantItToBeDefault(addressRequest.isYouWantItToBeDefault());
		
		addressRepository.save(address);
		
	}
	
	
	public void updateAddress(AddressRequest addressRequest, UUID addressId) {
		Address address = addressRepository.findById(addressId).get();
		address.setRegion(addressRequest.getRegion());
		address.setProvince(addressRequest.getProvince());
		address.setCity(addressRequest.getCity());
		address.setBarangay(addressRequest.getBarangay());
		address.setPostalCode(addressRequest.getPostalCode());
		address.setDetailedAddress(addressRequest.getDetailedAddress());
		address.setUserId(addressRequest.getUserId());
		address.setYouWantItToBeDefault(addressRequest.isYouWantItToBeDefault());
		
		addressRepository.save(address);
	}
	
	public void deleteAddress(UUID id) {
		Address address = addressRepository.findById(id).get();
		addressRepository.delete(address);
	}

	public List<Address> getAddressOfTheUser(UUID userId) {
		return addressRepository.findByUserId(userId);
	}


	public Address getSpecificAddress(UUID addressId) {
		return addressRepository.findById(addressId).get();
	}
	
//	public User fetchUserAndFindAddress(UUID userId) {
//		UUID user = userRepository.findById(userId).get().getId();
//		
//	}
}
