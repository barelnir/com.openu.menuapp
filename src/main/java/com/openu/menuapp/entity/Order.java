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

	//@OneToOne(cascade = {CascadeType.ALL})
    //@JoinColumn(name = "restaurant_uuid", referencedColumnName="uuid")
	//protected Restaurant restaurant;
	
	@OneToOne
    @JoinColumn(name = "dish_uuid", referencedColumnName="uuid")
	protected Dish dish;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
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
	 * @param dish
	 */
	public Order(Dish dish) {
		super("");
		this.dish = dish;
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

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the deliveryTime
	 */
	public Date getDeliveryTime() {
		return deliveryTime;
	}

	/**
	 * @param deliveryTime the deliveryTime to set
	 */
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	/**
	 * @return the deliveryAddress
	 */
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * @param deliveryAddress the deliveryAddress to set
	 */
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the restaurant
	 */
	//public Restaurant getRestaurant() {
	//	return restaurant;
	//}

	/**
	 * @param restaurant the restaurant to set
	 */
	//public void setRestaurant(Restaurant restaurant) {
	//	this.restaurant = restaurant;
	//}

	/**
	 * @return the dish
	 */
	public Dish getDish() {
		return dish;
	}

	/**
	 * @param dish the dish to set
	 */
	public void setDish(Dish dish) {
		this.dish = dish;
	}

	/**
	 * @return the selectedAdditionalOptions
	 */
	public Set<AdditionalOption> getSelectedAdditionalOptions() {
		return selectedAdditionalOptions;
	}

	/**
	 * @param selectedAdditionalOptions the selectedAdditionalOptions to set
	 */
	public void setSelectedAdditionalOptions(
			Set<AdditionalOption> selectedAdditionalOptions) {
		this.selectedAdditionalOptions = selectedAdditionalOptions;
	}
	
	
	
}
