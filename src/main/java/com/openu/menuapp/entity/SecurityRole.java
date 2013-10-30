/**
 * menuapp
 * 8 баеч 2013 21:52:18
 * SecurityRole.java
 *
 * Lior Negrin ID: 040829780
 * Nir Barel ID: 032483372
 */
package com.openu.menuapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "security_roles")
public class SecurityRole extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8810187207127121001L;
	@Column
	protected String roleName;

	/**
	 * Constructor
	 */
	public SecurityRole() {
		super("");
	}

	/**
	 * Constructor
	 * @param createdBy
	 * @param roleName
	 */
	public SecurityRole(String createdBy, String roleName) {
		super(createdBy);
		this.roleName = roleName;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


}
