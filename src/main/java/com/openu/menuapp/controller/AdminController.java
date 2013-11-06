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

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.openu.menuapp.entity.Address;
import com.openu.menuapp.entity.Restaurant;
import com.openu.menuapp.service.RestaurantService;
import com.openu.menuapp.utils.convertors.AddressConvertor;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Address.class, addressConvertor);
	}
	
	@Autowired
	private AddressConvertor addressConvertor;
	
	@Autowired
    private RestaurantService restaurantService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadAdminPage(Model model) {
        return "admin/admin";
    }
	
    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public String loadAdminRestaurantsPage(Model model, HttpServletRequest request) {
        List<Restaurant> restaurants = restaurantService.list();
        model.addAttribute("restaurants", restaurants);
        if ( request.getQueryString() != null && request.getQueryString().equals("saved=success"))
        {
        	model.addAttribute("saved", "success");
        }
        return "admin/restaurants";
    }
}
