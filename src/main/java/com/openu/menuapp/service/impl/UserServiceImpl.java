/**
 * menuapp
 * 8 баеч 2013 21:56:45
 * UserServiceImpl.java
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

import com.openu.menuapp.dao.impl.UserDaoImpl;
import com.openu.menuapp.entity.BaseEntity;
import com.openu.menuapp.entity.User;
import com.openu.menuapp.service.BaseEntityService;
import com.openu.menuapp.service.UserService;

@Service("userServiceImpl")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDaoImpl daoImpl;
	
	@Override
	@Transactional(readOnly = false)
	public <T extends BaseEntity> void saveOrUpdate(T baseEntity) {
		daoImpl.saveOrUpdate((User)baseEntity);

	}

	@Override
	@Transactional(readOnly = false)
	public void delete(String uuid) {
		User user = daoImpl.findByUUID(uuid);
        if (user != null) {
        	daoImpl.delete(user);
        }

	}

	@SuppressWarnings("unchecked")
	@Override
	public User findByUUID(String uuid) {
		return daoImpl.findByUUID(uuid);
	}

	@Override
	public List<User> findByCriteria(Criterion criterion) {
		return daoImpl.findByCriteria(criterion);
	}

}
