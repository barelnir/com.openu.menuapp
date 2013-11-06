/**
 * menuapp
 * 8 баеч 2013 22:01:07
 * RestaurantDaoImpl.java
 *
 * Lior Negrin ID: 040829780
 * Nir Barel ID: 032483372
 */
package com.openu.menuapp.dao.impl;

import org.springframework.stereotype.Repository;

import com.openu.menuapp.dao.BaseEntityDao;
import com.openu.menuapp.entity.Order;

@Repository
public class OrderDaoImpl extends BaseEntityDaoImpl<Order> implements BaseEntityDao<Order>
{

	/**
	 * Constructor
	 */
	protected OrderDaoImpl() {
        super(Order.class);
    }
}
