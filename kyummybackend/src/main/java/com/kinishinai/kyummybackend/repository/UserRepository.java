package com.kinishinai.kyummybackend.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kinishinai.kyummybackend.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, UUID>{

	Optional<User> findByEmail(String user);

	Optional<User> findByPhoneNumber(String phoneNumber);

	boolean existsByPhoneNumber(String phoneNumber);

	boolean existsByEmail(String email);

//	Iterable<UUID> findAllById(UUID userId);
	
}
