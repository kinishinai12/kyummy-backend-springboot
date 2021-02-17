package com.kinishinai.kyummybackend.model;

import java.util.Date;
import java.util.UUID;

public class PurchasedHistory {
	private UUID id;
	private String productName;
	private String price;
	private String category;
	private String quantity;
	private Date purchasedDate;
	private String img;
	private String userId;
	
	
	public PurchasedHistory() {}


	public PurchasedHistory(UUID id, String productName, String price, String category, String quantity,
			Date purchasedDate, String img, String userId) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
		this.purchasedDate = purchasedDate;
		this.img = img;
		this.userId = userId;
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


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public Date getPurchasedDate() {
		return purchasedDate;
	}


	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "PurchasedHistory [id=" + id + ", productName=" + productName + ", price=" + price + ", category="
				+ category + ", quantity=" + quantity + ", purchasedDate=" + purchasedDate + ", img=" + img
				+ ", userId=" + userId + "]";
	}


	
	
	
	
}
