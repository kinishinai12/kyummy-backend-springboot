package com.kinishinai.kyummybackend.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kinishinai.kyummybackend.model.AddToCart;

@Repository
public interface AddToCartRepository extends PagingAndSortingRepository<AddToCart, UUID>{

	AddToCart findAllById(UUID userId);

}
