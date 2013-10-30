/**
 * menuapp
 * 8 баеч 2013 21:36:38
 * User.java
 *
 * Lior Negrin ID: 040829780
 * Nir Barel ID: 032483372
 */
package com.openu.menuapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1891086337208998459L;

	@Column (nullable = false)
	protected String userName;
	
	@Column (nullable = false)
	protected String password;
	
	@Column (nullable = false)
	protected String displayName;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_uuid", referencedColumnName="uuid")
	protected Address address;
	
	@Column (nullable = false)
	protected String phone;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "securityRole_uuid", referencedColumnName="uuid")
	protected SecurityRole securityRole;
 	
	/**
	 * Constructor
	 */
	public User() {
		super("");
	}

	/**
	 * Constructor
	 * @param createdBy
	 * @param userName
	 * @param password
	 * @param displayName
	 * @param address
	 * @param phone
	 * @param securityRole
	 */
	public User(String createdBy, String userName, String password,
			String displayName, Address address, String phone,
			SecurityRole securityRole) {
		super(createdBy);
		this.userName = userName;
		this.password = password;
		this.displayName = displayName;
		this.address = address;
		this.phone = phone;
		this.securityRole = securityRole;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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
	 * @return the securityRole
	 */
	public SecurityRole getSecurityRole() {
		return securityRole;
	}

	/**
	 * @param securityRole the securityRole to set
	 */
	public void setSecurityRole(SecurityRole securityRole) {
		this.securityRole = securityRole;
	}

	

}
