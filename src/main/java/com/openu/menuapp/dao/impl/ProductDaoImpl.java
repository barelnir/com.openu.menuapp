package com.openu.menuapp.dao.impl;

import com.openu.menuapp.entity.Product;
import org.springframework.stereotype.Repository;



@Repository
public class ProductDaoImpl extends BaseEntityDaoImpl<Product>
{
	protected ProductDaoImpl() {
        super(Product.class);
    }
}
