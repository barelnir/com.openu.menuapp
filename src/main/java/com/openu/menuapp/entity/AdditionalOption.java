/**
 * menuapp
 * 22 баеч 2013 07:48:09
 * AdditionalOption.java
 *
 * Lior Negrin ID: 040829780
 * Nir Barel ID: 032483372
 */
package com.openu.menuapp.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "additional_options")
public class AdditionalOption extends BaseEntity {

	private static final long serialVersionUID = -2728833284832907394L;

	@Column (nullable = false)
	protected String name;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "availableAdditionalOptions")
	private Set<Dish> dishes = new HashSet<Dish>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "selectedAdditionalOptions")
	private Set<Order> orders = new HashSet<Order>();
	
	/**
	 * Constructor
	 */
	public AdditionalOption()
	{
		super("");
	}
	
	/**
	 * Constructor
	 * @param createdBy
	 * @param name
	 */
	public AdditionalOption(String createdBy, String name) {
		super(createdBy);
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dishes
	 */
	public Set<Dish> getDishes() {
		return dishes;
	}

	/**
	 * @param dishes the dishes to set
	 */
	public void setDishes(Set<Dish> dishes) {
		this.dishes = dishes;
	}

	/**
	 * @return the orders
	 */
	public Set<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
	

}
