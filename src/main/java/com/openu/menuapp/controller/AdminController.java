/**
 * menuapp
 * 28 баеч 2013 21:25:47
 * IndexController.java
 *
 * Lior Negrin ID: 040829780
 * Nir Barel ID: 032483372
 */
package com.openu.menuapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.openu.menuapp.entity.Restaurant;
import com.openu.menuapp.service.RestaurantService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
    private RestaurantService restaurantService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadAdminPage(Model model) {
        return "admin/admin";
    }
	
    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public String loadAdminRestaurantsPage(Model model) {
        List<Restaurant> restaurants = restaurantService.list();
        model.addAttribute("restaurants", restaurants);
        return "admin/restaurants";
    }

    @RequestMapping(value = "/restaurants/delete/{uuid}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable String uuid) {
    	restaurantService.delete(uuid);
        model.addAttribute("deleted", "success");
        List<Restaurant> restaurants = restaurantService.list();
        model.addAttribute("restaurants", restaurants);
        return "admin/restaurants";
    }
    
    
}
