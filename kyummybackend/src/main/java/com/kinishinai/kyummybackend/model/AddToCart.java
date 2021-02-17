package com.kinishinai.kyummybackend.model;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AddToCart {
    @Id
    @GeneratedValue
    @Column(length = 16)
	private UUID id;
	private String productName;
	@Column(length = 16)
	private String userId;
	private String price;
	private Instant dateAdded;
	private String quantity;
	private String img;
	private String category;
	private String color;
	private String flavor;
}
