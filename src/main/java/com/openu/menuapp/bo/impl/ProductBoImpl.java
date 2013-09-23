package com.openu.menuapp.bo.impl;

import com.openu.menuapp.bo.ProductBo;
import com.openu.menuapp.dao.ProductDao;
import com.openu.menuapp.model.Product;

public class ProductBoImpl implements ProductBo{

	ProductDao productDao;
	 
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
 
	public void save(Product product){
		productDao.save(product);
	}
 
	public void update(Product product){
		productDao.update(product);
	}
 
	public void delete(Product product){
		productDao.delete(product);
	}
 
	public Product findByProductId(long productId){
		return productDao.findByProductId(productId);
	}
	
}
