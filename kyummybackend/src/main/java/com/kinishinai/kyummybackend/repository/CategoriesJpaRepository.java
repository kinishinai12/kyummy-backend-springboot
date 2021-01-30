package com.kinishinai.kyummybackend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kinishinai.kyummybackend.model.Category;


@Repository
public interface CategoriesJpaRepository extends JpaRepository<Category, UUID>{

}
