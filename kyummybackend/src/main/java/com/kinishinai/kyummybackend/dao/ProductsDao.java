package com.kinishinai.kyummybackend.dao;

import org.springframework.stereotype.Service;

import com.kinishinai.kyummybackend.repository.ProductJpaRepository;
//import com.kinishinai.kyummybackend.service.IProductService;

@Service
public class ProductsDao{
	
	private final ProductJpaRepository repository;

	public ProductsDao(ProductJpaRepository repository) {
		this.repository = repository;
	}
	
	
}
