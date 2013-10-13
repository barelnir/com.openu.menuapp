package com.openu.menuapp.service.impl;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.openu.menuapp.dao.impl.ProductDaoImpl;
import com.openu.menuapp.entity.BaseEntity;
import com.openu.menuapp.entity.Product;
import com.openu.menuapp.service.BaseEntityService;
import com.openu.menuapp.service.ProductService;


import java.util.List;

@Service("productServiceImpl")
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDaoImpl productDao;

	@SuppressWarnings("unchecked")
	@Override
	public Product findByUUID(String uuid) {
		return productDao.findByUUID(uuid);
	}

	@Override
	@Transactional(readOnly = false)
	public <T extends BaseEntity> void saveOrUpdate(T baseEntity) {
		productDao.saveOrUpdate((Product)baseEntity);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(String uuid) {
		Product product = productDao.findByUUID(uuid);
        if (product != null) {
            productDao.delete(product);
        }
	}

	@Override
	public List<Product> findByCriteria(Criterion criterion) {
		return productDao.findByCriteria(criterion);
	}

   
}
