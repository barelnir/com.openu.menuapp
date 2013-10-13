/**
 * menuapp
 * 8 баеч 2013 22:01:07
 * UserDaoImpl.java
 *
 * Lior Negrin ID: 040829780
 * Nir Barel ID: 032483372
 */
package com.openu.menuapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.openu.menuapp.dao.BaseEntityDao;
import com.openu.menuapp.entity.User;

@Repository
public class UserDaoImpl extends BaseEntityDaoImpl<User> implements BaseEntityDao<User>
{

	/**
	 * Constructor
	 */
	protected UserDaoImpl() {
        super(User.class);
    }
}
