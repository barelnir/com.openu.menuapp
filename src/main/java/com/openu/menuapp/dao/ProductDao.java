package com.openu.menuapp.dao;

import com.openu.menuapp.model.Product;

public interface ProductDao {

	void save(Product product);
	void update(Product product);
	void delete(Product product);
	Product findByProductId(long productId);
	
}
