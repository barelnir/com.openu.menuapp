/**
 * menuapp
 * 8 баеч 2013 22:06:12
 * RestaurantServiceTest.java
 *
 * Lior Negrin ID: 040829780
 * Nir Barel ID: 032483372
 */
package com.openu.menuapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.openu.menuapp.entity.Address;
import com.openu.menuapp.entity.Dish;
import com.openu.menuapp.entity.Restaurant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/hibernateContext.xml"})
public class RestaurantServiceTest {

	@Autowired
    private RestaurantService baseEntityService;
	private DishService dishService;
	
	@Test
    public void testSave() throws Exception {
    	String uuid = createObject();
        Restaurant found = baseEntityService.findByUUID(uuid);
        assertEquals(uuid, found.getUuid());
    }

    static int i = 1;
    
    private String createObject() {
    	Restaurant obj = new Restaurant("","La Gardia",new Address("","Tel Aviv","Main",6,4,"CP",5,"2",323232),"054-23325654","nir",true);
        //Dish dish = new Dish("","habita","nice",50);
        //dishService.saveOrUpdate(dish);
        //obj.addDish(dish);
    	baseEntityService.saveOrUpdate(obj);
        return obj.getUuid();
    }
	
    @Test
    public void testDelete() throws Exception {
    	String uuid = createObject();
        assertNotNull(baseEntityService.findByUUID(uuid));
        baseEntityService.delete(uuid);
    }

    @Test
    public void testUpdate() throws Exception {
    	String uuid = createObject();
    	Restaurant obj = baseEntityService.findByUUID(uuid);
        assertNotNull(obj);
        obj.setName("newUserName");
        baseEntityService.saveOrUpdate(obj);

        Restaurant found = baseEntityService.findByUUID(uuid);
        assertNotNull(found);
        assertEquals("newUserName", found.getName());
    }
}
