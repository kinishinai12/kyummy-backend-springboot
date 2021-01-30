package com.kinishinai.kyummybackend.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_category")
public class Category {
	
	@Id
	@GeneratedValue
	private UUID id;
	private String categoryName;
	private String categoryQuantity;
	private Date dateAdded;
	
	public Category() {}
	
	public Category(UUID id, String categoryName, String categoryQuantity, Date dateAdded) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.categoryQuantity = categoryQuantity;
		this.dateAdded = dateAdded;
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryQuantity() {
		return categoryQuantity;
	}
	public void setCategoryQuantity(String categoryQuantity) {
		this.categoryQuantity = categoryQuantity;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	@Override
	public String toString() {
		return "Categories [id=" + id + ", categoryName=" + categoryName + ", categoryQuantity=" + categoryQuantity
				+ ", dateAdded=" + dateAdded + "]";
	}
	
	
	
}
