/**
 * menuapp
 * 8 баеч 2013 21:44:11
 * Address.java
 *
 * Lior Negrin ID: 040829780
 * Nir Barel ID: 032483372
 */
package com.openu.menuapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "addresses")
public class Address extends BaseEntity {

	@Column (nullable = false)
	private String city;
	
	@Column (nullable = false)
	private String street;
	
	@Column (nullable = false)
	private int buildingNumber;
	
	@Column
	private int apartmentNumber;
	
	@Column (nullable = false)
	private String company;
	
	@Column
	private int floor;
	
	@Column
	private String entrance;
	
	@Column
	private long zipCode;
	
	/**
	 * Constructor
	 */
	public Address() {
		super();
	}

	/**
	 * Constructor
	 * @param createdBy
	 * @param city
	 * @param street
	 * @param buildingNumber
	 * @param apartmentNumber
	 * @param company
	 * @param floor
	 * @param entrance
	 * @param zipCode
	 */
	public Address(String createdBy, String city, String street,
			int buildingNumber, int appartmentNumber, String company,
			int floor, String entrance, long zipCode) {
		super(createdBy);
		this.city = city;
		this.street = street;
		this.buildingNumber = buildingNumber;
		this.apartmentNumber = appartmentNumber;
		this.company = company;
		this.floor = floor;
		this.entrance = entrance;
		this.zipCode = zipCode;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the buildingNumber
	 */
	public int getBuildingNumber() {
		return buildingNumber;
	}

	/**
	 * @param buildingNumber the buildingNumber to set
	 */
	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	/**
	 * @return the apartmentNumber
	 */
	public int getAppartmentNumber() {
		return apartmentNumber;
	}

	/**
	 * @param apartmentNumber the apartmentNumber to set
	 */
	public void setAppartmentNumber(int appartmentNumber) {
		this.apartmentNumber = appartmentNumber;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the floor
	 */
	public int getFloor() {
		return floor;
	}

	/**
	 * @param floor the floor to set
	 */
	public void setFloor(int floor) {
		this.floor = floor;
	}

	/**
	 * @return the entrance
	 */
	public String getEntrance() {
		return entrance;
	}

	/**
	 * @param entrance the entrance to set
	 */
	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}

	/**
	 * @return the zipCode
	 */
	public long getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

}
