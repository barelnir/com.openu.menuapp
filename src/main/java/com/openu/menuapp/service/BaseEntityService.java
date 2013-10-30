package com.openu.menuapp.service;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.openu.menuapp.entity.BaseEntity;

public interface BaseEntityService {

	<T extends BaseEntity> void saveOrUpdate(T baseEntity);
    void delete(String uuid);
    <T extends BaseEntity> T findByUUID(String uuid);
    <T extends BaseEntity> List<T> findByCriteria(Criterion criterion);
    <T extends BaseEntity> List<T> list();
	
}
