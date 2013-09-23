package com.openu.menuapp.bo;

import com.openu.menuapp.model.Product;

public interface ProductBo {

	void save(Product product);
	void update(Product product);
	void delete(Product product);
	Product findByProductId(long productId);
	
}

