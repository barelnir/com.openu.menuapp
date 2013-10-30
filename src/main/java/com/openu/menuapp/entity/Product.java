package com.openu.menuapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table (name = "products")
public class Product extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4847600085055657001L;

	@Column (nullable = false)
	protected String productName;
	
	@Column (nullable = false)
	protected long productPrice;
		
	/**
	 * c'tor
	 */
	public Product() {
		super("");
	}
	
	/**
	 * c'tor
	 * @param guid
	 * @param creationTime
	 * @param modificationTime
	 * @param createdBy
	 * @param productName
	 * @param productPrice
	 */
	public Product(String createdBy, String productName, Long productPrice)
	{
		super(createdBy);
		setProductName(productName);
		setProductPrice(productPrice);
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

	/**
	 * @return the productPrice
	 */
	public long getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	

	
}
