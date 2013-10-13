package com.openu.menuapp.service;

import com.openu.menuapp.entity.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/hibernateContext.xml"})
public class ProductServiceTest {

    @Autowired
    private ProductService baseEntityService;

    //private final String productId = "product01";

    //@After
    //public void tearDown() throws Exception {
    //    baseEntityService.delete(productId);
    //}

    @Test
    public void testSaveProduct() throws Exception {
    	String uuid = createProduct();
        Product found = baseEntityService.findByUUID(uuid);
        assertEquals(uuid, found.getUuid());
    }

    static int i = 1;
    
    private String createProduct() {
        Product product = new Product(UUID.randomUUID().toString(),"product0" + i++,(long)500);
        baseEntityService.saveOrUpdate(product);
        return product.getUuid();
    }

    //@Test
    //public void testSearchProduct() throws Exception {
    //    createProduct();
    //    List<Product> products = baseEntityService.findProducts("product01");
    //    assertEquals(1, products.size());
    //    assertEquals("product01", products.iterator().next().getGuid());
    //}

    @Test
    public void testDeleteProduct() throws Exception {
    	String uuid = createProduct();
        assertNotNull(baseEntityService.findByUUID(uuid));
        baseEntityService.delete(uuid);
        //assertNull(baseEntityService.findByProductId("product01"));
    }

    @Test
    public void testUpdateProduct() throws Exception {
    	String uuid = createProduct();
        Product product = baseEntityService.findByUUID(uuid);
        assertNotNull(product);
        assertEquals("product0" + --i, product.getProductName());
        assertEquals((long)500, product.getProductPrice());

        product.setProductName("newProductName");
        product.setProductPrice((long) 100);
        baseEntityService.saveOrUpdate(product);

        Product found = baseEntityService.findByUUID(uuid);
        assertNotNull(found);
        assertEquals("newProductName", found.getProductName());
        assertEquals((long)100, found.getProductPrice());



    }
}