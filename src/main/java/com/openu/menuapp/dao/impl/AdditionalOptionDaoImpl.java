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
import com.openu.menuapp.entity.AdditionalOption;

@Repository
public class AdditionalOptionDaoImpl extends BaseEntityDaoImpl<AdditionalOption> implements BaseEntityDao<AdditionalOption>
{

	/**
	 * Constructor
	 */
	protected AdditionalOptionDaoImpl() {
        super(AdditionalOption.class);
    }
}
