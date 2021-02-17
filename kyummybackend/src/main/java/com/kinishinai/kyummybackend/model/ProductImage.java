package com.kinishinai.kyummybackend.model;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {
	@Id
	@GeneratedValue
	@Column(length = 16)
	private UUID id;
	private String image;
	@Column(length = 16)
	private UUID productId;
}
