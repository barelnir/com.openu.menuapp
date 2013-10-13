package com.openu.menuapp.service;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.Criterion;

import com.openu.menuapp.entity.BaseEntity;

public interface BaseEntityService {

	<T extends BaseEntity> void saveOrUpdate(T baseEntity);
    void delete(String uuid);
    <T extends BaseEntity> T findByUUID(String uuid);
    List<? extends BaseEntity> findByCriteria(Criterion criterion);
	
}
