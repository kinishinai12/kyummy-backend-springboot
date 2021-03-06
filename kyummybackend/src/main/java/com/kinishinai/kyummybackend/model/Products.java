package com.kinishinai.kyummybackend.model;

import java.util.Date;
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
public class Products {
	@Id
	@GeneratedValue
	@Column(length = 16)
	private UUID id;
	
	@Column(name="product_name")
	private String productName;
	private String price;
	private String quantity;
	private String productDescription;
	private Date dateAdded;
	private String img;
	private String category;
	
}
