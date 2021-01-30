package com.kinishinai.kyummybackend.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class KoreanFame {
	@Id
	@GeneratedValue
	private UUID id;
	
	private String productName;
	private String price;
	private String quantity;
	private String productDescription;
	private Date dateAdded;
	private String img;
	private String category;
	
	public KoreanFame() {}
	
	public KoreanFame(UUID id, String productName, String price, String quantity, String productDescription,
			Date dateAdded, String img, String category) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.productDescription = productDescription;
		this.dateAdded = dateAdded;
		this.img = img;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "KoreanFame [id=" + id + ", productName=" + productName + ", price=" + price + ", quantity=" + quantity
				+ ", productDescription=" + productDescription + ", dateAdded=" + dateAdded + ", img=" + img
				+ ", category=" + category + "]";
	}
	
	
	
}
