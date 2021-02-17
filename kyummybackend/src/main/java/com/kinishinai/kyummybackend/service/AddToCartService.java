package com.kinishinai.kyummybackend.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kinishinai.kyummybackend.dto.AddToCartRequest;
import com.kinishinai.kyummybackend.model.AddToCart;
import com.kinishinai.kyummybackend.repository.AddToCartRepository;

@Service
public class AddToCartService {
	@Autowired
	private AddToCartRepository addToCartRepository;
	
	@Transactional
	public void registerAddToCart(AddToCartRequest addToCartRequest) {
		AddToCart addToCart = new AddToCart();
		addToCart.setProductName(addToCartRequest.getProductName());
		addToCart.setUserId(addToCartRequest.getUserId());
		addToCart.setPrice(addToCartRequest.getPrice());
		addToCart.setDateAdded(Instant.now());
		addToCart.setQuantity(addToCartRequest.getQuantity());
		addToCart.setImg(addToCartRequest.getImg());
		addToCart.setCategory(addToCartRequest.getCategory());
		addToCart.setColor(addToCartRequest.getColor());
		addToCart.setFlavor(addToCartRequest.getFlavor());
		
		addToCartRepository.save(addToCart);
	}
	
	public AddToCart getAddToCartOfUser(UUID userId) {
		return addToCartRepository.findById(userId).get();
	}
}
