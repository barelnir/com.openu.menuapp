/**
 * menuapp
 * 8 баеч 2013 22:06:12
 * UserServiceTest.java
 *
 * Lior Negrin ID: 040829780
 * Nir Barel ID: 032483372
 */
package com.openu.menuapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.openu.menuapp.entity.Address;
import com.openu.menuapp.entity.SecurityRole;
import com.openu.menuapp.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/hibernateContext.xml"})
public class UserServiceTest {

	@Autowired
    private UserService baseEntityService;
	
	@Test
    public void testSave() throws Exception {
    	String uuid = createObject();
        User found = baseEntityService.findByUUID(uuid);
        assertEquals(uuid, found.getUuid());
    }

    static int i = 1;
    
    private String createObject() {
    	User user = new User(UUID.randomUUID().toString(),"nir","nir","Nir Barel",new Address(UUID.randomUUID().toString(),"Tel Aviv","Main",6,4,"CP",5,"2",323232),"054-2323232",new SecurityRole(UUID.randomUUID().toString(),"Admin"));
        baseEntityService.saveOrUpdate(user);
        return user.getUuid();
    }
	
    @Test
    public void testDelete() throws Exception {
    	String uuid = createObject();
        assertNotNull(baseEntityService.findByUUID(uuid));
        baseEntityService.delete(uuid);
        //assertNull(baseEntityService.findByProductId("product01"));
    }

    @Test
    public void testUpdate() throws Exception {
    	String uuid = createObject();
    	User user = baseEntityService.findByUUID(uuid);
        assertNotNull(user);
        //assertEquals("product0" + --i, product.getProductName());
        //assertEquals((long)500, product.getProductPrice());

        user.setUserName("newUserName");
        user.setPassword("123");
        baseEntityService.saveOrUpdate(user);

        User found = baseEntityService.findByUUID(uuid);
        assertNotNull(found);
        assertEquals("newUserName", found.getUserName());
        assertEquals(123, found.getPassword());



    }
}
