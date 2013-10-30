/**
 * menuapp
 * 19 баеч 2013 13:11:06
 * Dish.java
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
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "dishes")
public class Dish extends BaseEntity {

	private static final long serialVersionUID = -5761390462307493975L;

	@Column (nullable = false)
	protected String name;
	
	@Column (nullable = false)
	protected String description;
	
	@Column (nullable = false)
	protected double price;
		
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "dishes_additional_options", joinColumns = { 
			@JoinColumn(name = "dishes_uuid", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "additionalOptions_uuid", 
					nullable = false, updatable = false) })
	protected Set<AdditionalOption> availableAdditionalOptions = new HashSet<AdditionalOption>();
		
	/**
	 * Constructor
	 */
	public Dish() {
		super("");
	}

	/**
	 * Constructor
	 * @param createdBy
	 * @param name
	 * @param description
	 * @param price
	 */
	public Dish(String createdBy, String name, String description,
			double price) {
		super(createdBy);
		this.name = name;
		this.description = description;
		this.price = price;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the availableAdditionalOptions
	 */
	public Set<AdditionalOption> getAdditionalOptions() {
		return availableAdditionalOptions;
	}

	/**
	 * @param availableAdditionalOptions the availableAdditionalOptions to set
	 */
	public void setAdditionalOptions(Set<AdditionalOption> additionalOptions) {
		this.availableAdditionalOptions = additionalOptions;
	}
	
	/**
	 * @param additionalOption the additionalOption to add
	 */
	public void addAdditionalOption(AdditionalOption additionalOption) {
		this.availableAdditionalOptions.add(additionalOption);
	}

	

}
