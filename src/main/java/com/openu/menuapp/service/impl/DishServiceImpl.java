/**
 * menuapp
 * 8 баеч 2013 21:56:45
 * RestaurantServiceImpl.java
 *
 * Lior Negrin ID: 040829780
 * Nir Barel ID: 032483372
 */
package com.openu.menuapp.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openu.menuapp.dao.impl.DishDaoImpl;
import com.openu.menuapp.entity.BaseEntity;
import com.openu.menuapp.entity.Dish;
import com.openu.menuapp.service.DishService;

@Service("dishServiceImpl")
@Transactional(readOnly = true)
public class DishServiceImpl implements DishService {

	@Autowired
    private DishDaoImpl daoImpl;
	
	@Transactional(readOnly = false)
	public <T extends BaseEntity> void saveOrUpdate(T baseEntity) {
		daoImpl.saveOrUpdate((Dish)baseEntity);

	}

	@Transactional(readOnly = false)
	public void delete(String uuid) {
		Dish obj = daoImpl.findByUUID(uuid);
        if (obj != null) {
        	daoImpl.delete(obj);
        }

	}

	@SuppressWarnings("unchecked")
	public Dish findByUUID(String uuid) {
		return daoImpl.findByUUID(uuid);
	}

	@SuppressWarnings("unchecked")
	public List<Dish> findByCriteria(Criterion criterion) {
		return daoImpl.findByCriteria(criterion);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dish> list() {
		return daoImpl.list();
	}

}
