package com.kinishinai.kyummybackend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kinishinai.kyummybackend.model.KoreanFame;
import com.kinishinai.kyummybackend.model.Products;
import com.kinishinai.kyummybackend.repository.KoreanFameJpaRepository;
import com.kinishinai.kyummybackend.repository.KoreanFameRepository;

@RestController
@CrossOrigin(origins="https://localhost:3000")
public class KoreanFameController {
	
	
		@Autowired
		private KoreanFameRepository koreanFameRepository;
		
		@Autowired
		private KoreanFameJpaRepository koreanFameJpaRepo;
		
		@GetMapping("/koreanfame/{category}/{page}/{size}")
		public Slice<KoreanFame> findAllByCategory(@PathVariable String category,
													@PathVariable int page, 
													@PathVariable int size){
			
			Pageable requestedPage = PageRequest.of(page, size);
			Slice<KoreanFame> product  = koreanFameRepository.findAllByCategory(category, requestedPage);
			return product;
		
}
		@GetMapping("/koreanfame/products")
		public List<KoreanFame> allProducts(){
			return koreanFameJpaRepo.findAll();
		}
		
//		@GetMapping("/product/{id}")
//		public Products getProduct(@PathVariable UUID id){
//			return productRepository.findById(id).get();
//		}
		
		@GetMapping("/koreanfame/{id}")
		public KoreanFame getKoreanFameProduct(@PathVariable UUID id) {
			return koreanFameJpaRepo.findById(id).get();
		}
}
