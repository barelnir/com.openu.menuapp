package com.openu.menuapp.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.openu.menuapp.dao.ProductDao;
import com.openu.menuapp.model.Product;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao{
	 
		public void save(Product product){
			getHibernateTemplate().save(product);
		}
	 
		public void update(Product product){
			getHibernateTemplate().update(product);
		}
	 
		public void delete(Product product){
			getHibernateTemplate().delete(product);
		}
	 
		public Product findByProductId(long productId){
			List list = getHibernateTemplate().find(
	                      "from Product where productPrice=?",productId
	                );
			return (Product)list.get(0);
		}
	 
	}