package com.openu.menuapp.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "Orders")
public class Order extends BaseEntity {

	@Column (name = "COMMENTS")
	private String comments;

	

	/**
	 * c'tor
	 */
	public Order() {
		super();
	}
	
	/**
	 * c'tor
	 * @param creationTime
	 * @param modificationTime
	 * @param createdBy
	 * @param comments
	 */
	public Order(String createdBy, String comments) {
		super(createdBy);
		setComments(comments);
	}



	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
}
