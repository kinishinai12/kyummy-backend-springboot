package com.kinishinai.kyummybackend.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartRequest {
	private String productName;
	private String userId;
	private String price;
	private Instant dateAdded;
	private String quantity;
	private String img;
	private String category;
	private String color;
	private String flavor;
}
