package com.openu.menuapp.dao;

import org.hibernate.criterion.Criterion;

import com.openu.menuapp.entity.BaseEntity;

import java.util.List;

public interface BaseEntityDao<E extends BaseEntity> {

	void saveOrUpdate(E e);
    void delete(E e);
    E findByUUID(String uuid);
    List<E> findByCriteria(Criterion criterion);
    List<E> list();
}
