package com.kinishinai.kyummybackend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kinishinai.kyummybackend.model.Address;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, UUID>{

	List<Address> findByUserId(UUID userId);

//	Address findAllById(UUID userId);
	
//	@Query(value="select * from Address where userId = :userId", nativeQuery = true)
//	Address findByUserIdInAddress(@Param(value = "userId") UUID userId);

}
