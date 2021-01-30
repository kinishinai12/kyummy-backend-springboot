package com.kinishinai.kyummybackend.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Products {
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name="product_name")
	private String productName;
	private String price;
	private String quantity;
	private String productDescription;
	private Date dateAdded;
	private String img;
	private String img1;
	private String img2;
	private String img3;
	private String category;
	
	public Products() {}
	public Products(UUID id, String productName, String price, String quantity, String productDescription,
			Date dateAdded, String img, String img1, String img2, String img3, String category) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.productDescription = productDescription;
		this.dateAdded = dateAdded;
		this.img = img;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.category = category;
	}
	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public Date getDateAdded() {
		return dateAdded;
	}


	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}


	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getImg1() {
		return img1;
	}
	
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	
	public String getImg2() {
		return img2;
	}
	
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	
	public String getImg3() {
		return img3;
	}
	
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	@Override
	public String toString() {
		return "Products [id=" + id + ", productName=" + productName + ", price=" + price + ", quantity=" + quantity
				+ ", productDescription=" + productDescription + ", dateAdded=" + dateAdded + ", img=" + img + ", img1="
				+ img1 + ", img2=" + img2 + ", img3=" + img3 + ", category=" + category + "]";
	}

	
	
	
}
