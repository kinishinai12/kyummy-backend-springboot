package com.kinishinai.kyummybackend.model;

import java.util.List;

public class ResponseProduct {
	private List<Products> product;
	private int totalPages;
	private int pageNumber;
	private int pageSize;
	
	public ResponseProduct() {}
	
	public ResponseProduct(List<Products> product, int totalPages, int pageNumber, int pageSize) {
		super();
		this.product = product;
		this.totalPages = totalPages;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	public List<Products> getProduct() {
		return product;
	}

	public void setProduct(List<Products> product) {
		this.product = product;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "ResponseProduct [product=" + product + ", totalPages=" + totalPages + ", pageNumber=" + pageNumber
				+ ", pageSize=" + pageSize + "]";
	}
	
	
	
	
}
