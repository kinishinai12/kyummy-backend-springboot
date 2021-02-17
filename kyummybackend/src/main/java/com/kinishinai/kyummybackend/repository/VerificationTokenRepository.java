package com.kinishinai.kyummybackend.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kinishinai.kyummybackend.model.VerificationToken;
@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, UUID> {
	
	//to search token in the database
	Optional<VerificationToken> findByToken(String token);

}
