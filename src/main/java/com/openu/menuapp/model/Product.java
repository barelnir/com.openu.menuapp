package com.openu.menuapp.model;

import java.io.Serializable;

public class Product implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private Long productId;
	private Long productPrice;
	private String productName;
	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/**
	 * @return the productPrice
	 */
	public Long getProductPrice() {
		return productPrice;
	}
	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
 
	//getter and setter methods...
}
