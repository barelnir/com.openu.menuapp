package com.openu.menuapp.dao.impl;

import com.openu.menuapp.dao.BaseEntityDao;
import com.openu.menuapp.entity.BaseEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

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

	public E findByUUID(String uuid) {
    	@SuppressWarnings("unchecked")
		E baseEntity = (E) getCurrentSession().get(entityClass, uuid);
    	return baseEntity; 
    }

    public void saveOrUpdate(E e) {
        getCurrentSession().saveOrUpdate(e);
    }

    public void delete(E e) {
        getCurrentSession().delete(e);
    }

	@SuppressWarnings("unchecked")
	public List<E> findByCriteria(Criterion criterion) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.add(criterion);
        return criteria.list();
    }
	
	@SuppressWarnings("unchecked")
	public List<E> list() {
        return getCurrentSession().createCriteria(entityClass).list();
    }
	
}
