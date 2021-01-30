package com.kinishinai.kyummybackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kinishinai.kyummybackend.model.Category;
import com.kinishinai.kyummybackend.repository.CategoriesJpaRepository;

@RestController
@CrossOrigin(origins="https://localhost:3000")
public class CategoriesController {
	
	@Autowired
	private CategoriesJpaRepository categoryRepository;
	
	@GetMapping("/categories")
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
}
