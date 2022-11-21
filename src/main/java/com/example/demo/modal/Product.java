package com.example.demo.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private String productCategory;
	private Long productRate;
	private String description ;
	private String rating;
	private String imageurl;

	
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Long getProductRate() {
		return productRate;
	}
	public void setProductRate(Long productRate) {
		this.productRate = productRate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description ) {
		this.description = description;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	
	public Product(Long productId, String productName, String productCategory, Long productRate, String description, String rating, String imageurl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productRate = productRate;
		this.description = description;
		this.rating = rating;
		this.imageurl = imageurl;
		
	}
	public Product() {}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productRate=" + productRate + ", description=" + description + ", rating="
				+ rating + ", imageurl=" + imageurl + "]";
	}
	
	
	
	
}
