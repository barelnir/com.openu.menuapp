package com.openu.menuapp.dao.impl;

import com.openu.menuapp.dao.BaseEntityDao;
import com.openu.menuapp.entity.BaseEntity;
import com.openu.menuapp.entity.Product;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

// This BaseEntityDaoImpl need to be extended for every sub class of BaseEntity
// See ProductDaoImpl
public abstract class BaseEntityDaoImpl<E extends BaseEntity> implements BaseEntityDao<E> {

    private Class<E> entityClass;

    protected BaseEntityDaoImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
    
    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	@Override
    public E findByUUID(String uuid) {
    	E baseEntity = (E) getCurrentSession().get(entityClass, uuid);
    	return baseEntity; 
    }

    @Override
    public void saveOrUpdate(E e) {
        getCurrentSession().saveOrUpdate(e);
    }

    @Override
    public void delete(E e) {
        getCurrentSession().delete(e);
    }

	@SuppressWarnings("unchecked")
	@Override
    public List<E> findByCriteria(Criterion criterion) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.add(criterion);
        return criteria.list();
    }
}
