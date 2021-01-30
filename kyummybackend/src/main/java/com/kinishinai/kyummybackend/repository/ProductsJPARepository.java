package com.kinishinai.kyummybackend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kinishinai.kyummybackend.model.Products;

@Repository
public interface ProductsJPARepository extends JpaRepository<Products, UUID>{
	
}
