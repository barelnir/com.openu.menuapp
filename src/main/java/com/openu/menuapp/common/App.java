package com.openu.menuapp.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.openu.menuapp.bo.ProductBo;
import com.openu.menuapp.model.Product;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = 
    	  new ClassPathXmlApplicationContext("resources/config/BeanLocations.xml");
 
    	ProductBo productBo = (ProductBo)appContext.getBean("productBo");
 
    	/** insert **/
    	Product product = new Product();
    	product.setProductPrice((long)7668);
    	product.setProductName("HAIO");
    	productBo.save(product);
 
    	/** select **/
    	Product product2 = productBo.findByProductId(7668);
    	System.out.println(product2);
 
    	/** update **/
    	product2.setProductName("HAIO-1");
    	productBo.update(product2);
 
    	/** delete **/
    	productBo.delete(product2);
 
    	System.out.println("Done");
    }
}
