/**
 * menuapp
 * 19 баеч 2013 12:37:04
 * Restaurant.java
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table (name = "restaurants")
public class Restaurant extends BaseEntity {

	private static final long serialVersionUID = -816483382411954113L;
	
	@Column (nullable = false)
	protected String name;
	
	@OneToOne()
	@Cascade({CascadeType.ALL})
    @JoinColumn(name = "address_uuid", referencedColumnName="uuid")
	protected Address address;
	
	@Column (nullable = false)
	protected String phone;
	
	@Column (nullable = false)
	protected String managerName;
	
	@Column (nullable = false)
	protected boolean kosher;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant", orphanRemoval=true)
	@Cascade({CascadeType.ALL})
	protected Set<Dish> dishes = new HashSet<Dish>();
	
	/**
	 * Constructor
	 */
	public Restaurant() {
		super("");
	}
	
	/**
	 * Constructor
	 * @param createdBy
	 * @param name
	 * @param address
	 * @param phone
	 * @param managerName
	 * @param kosher
	 */
	public Restaurant(String createdBy, String name, Address address, String phone,
			String managerName, boolean kosher) {
		super(createdBy);
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.managerName = managerName;
		this.kosher = kosher;
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
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the managerName
	 */
	public String getManagerName() {
		return managerName;
	}

	/**
	 * @param managerName the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	/**
	 * @return the kosher
	 */
	public boolean isKosher() {
		return kosher;
	}

	/**
	 * @param kosher the kosher to set
	 */
	public void setKosher(boolean kosher) {
		this.kosher = kosher;
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
	 * @param dish the dish to add
	 */
	public void addDish(Dish dish) {
		this.dishes.add(dish);
	}
	
	
	
}
