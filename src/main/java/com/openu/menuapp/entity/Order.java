package com.openu.menuapp.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "orders")
public class Order extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4849493986535123886L;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_uuid", referencedColumnName="uuid")
	protected User user;
	
	@Column (nullable = false)
	protected Date deliveryTime;

	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_uuid", referencedColumnName="uuid")
	protected Address deliveryAddress;
	
	@Column
	protected String comments;
	
	@Column (nullable = false)
	protected boolean status;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "orders_additional_options", joinColumns = { 
			@JoinColumn(name = "orders_uuid", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "additionalOptions_uuid", 
					nullable = false, updatable = false) })
	protected Set<AdditionalOption> selectedAdditionalOptions = new HashSet<AdditionalOption>();
	
	/**
	 * Constructor
	 */
	public Order() {
		super("");
	}

	/**
	 * Constructor
	 * @param createdBy
	 * @param user
	 * @param deliveryTime
	 * @param deliveryAddress
	 * @param comments
	 * @param status
	 * @param selectedAdditionalOptions
	 */
	public Order(String createdBy, User user, Date deliveryTime,
			Address deliveryAddress, String comments, boolean status,
			Set<AdditionalOption> selectedAdditionalOptions) {
		super(createdBy);
		this.user = user;
		this.deliveryTime = deliveryTime;
		this.deliveryAddress = deliveryAddress;
		this.comments = comments;
		this.status = status;
		this.selectedAdditionalOptions = selectedAdditionalOptions;
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
