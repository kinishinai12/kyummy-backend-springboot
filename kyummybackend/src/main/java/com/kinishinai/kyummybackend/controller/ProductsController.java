package com.kinishinai.kyummybackend.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kinishinai.kyummybackend.model.Products;
import com.kinishinai.kyummybackend.repository.ProductJpaRepository;
//import com.kinishinai.kyummybackend.service.IProductService;

@RestController
@CrossOrigin(origins="https://localhost:3000")
public class ProductsController {
	@Autowired
	private ProductJpaRepository productRepository;
	
	// Alcohol Drinks
	@GetMapping("/pagebycategory/{category}/{page}/{size}")
	public Slice<Products> findAllByCategory (@PathVariable String category,
												@PathVariable int page, 
												@PathVariable int size){
		
		Pageable requestedPage = PageRequest.of(page, size);
		Slice<Products> product  = productRepository.findAllByCategory(category, requestedPage);
		return product;
	}
	
	// fetching specific product by id
	@GetMapping("/product/{id}")
	public Products getProduct(@PathVariable UUID id){
		return productRepository.findById(id).get();
	}
	// fetching all the products
	@GetMapping("/product/allproducts")
	public List<Products> getAllProduct() {
	return (List<Products>) productRepository.findAll();
	}
	
	// paginated product 
//	@GetMapping("/moreproducts/{page}/{size}")
//	public List<Products> getAllProducts(@PathVariable int page, 
//			@PathVariable int size){
//				
//				Pageable requestedPage = PageRequest.of(page, size);
//				Page<Products> products  = productRepository.findAll(requestedPage);
//				return products.toList();
//	}
	
	@GetMapping("/categorypage/{category}/{page}/{size}")
	public Page<Products> getProductByCategory(@PathVariable String category, @PathVariable int page, @PathVariable int size){
		Pageable requestedPage = PageRequest.of(page, size);
		Page<Products> products = productRepository.findProductByCategory(category, requestedPage);
		return products;
	}
	
	@GetMapping("/paginatedproducts/{pageNumber}/{pageSize}")
	public Page<Products> paginatedAndSortedProducts(@PathVariable int pageNumber, @PathVariable int pageSize){
		Pageable requestedPage = PageRequest.of(pageNumber, pageSize, Sort.by("productName").ascending());
		Page<Products> products = productRepository.findAll(requestedPage);
		return products;
	}
	
	@GetMapping("/SearchingProducts/{productName}/{pageNumber}")
	public Page<Products> liveSearch(@PathVariable Optional<String> productName, 
			@PathVariable Optional<Integer> pageNumber,
			@RequestParam Optional<String> sortBy){
		
		Pageable requestedPage = PageRequest.of(pageNumber.orElse(0), 5, Sort.Direction.ASC, sortBy.orElse("id"));
		 return productRepository.findByProductName(productName.orElse("_"), requestedPage);
		//		return productRepository.findByProductName(productName.orElse("_"), 
//				new PageRequest(pageNumber.orElse(0), 5, Sort.Direction.ASC, sortBy.orElse("id")));
	}
	
	
	
}
