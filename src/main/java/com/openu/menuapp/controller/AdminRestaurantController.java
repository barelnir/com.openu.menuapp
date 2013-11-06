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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.openu.menuapp.entity.Address;
import com.openu.menuapp.entity.Restaurant;
import com.openu.menuapp.service.RestaurantService;
import com.openu.menuapp.utils.convertors.AddressConvertor;

@Controller
@RequestMapping(value = "/admin/restaurant")
public class AdminRestaurantController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Address.class, addressConvertor);
	}
	
	@Autowired
	private AddressConvertor addressConvertor;
	
	@Autowired
    private RestaurantService restaurantService;

	@RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public String loadAdminRestaurantPage(Model model, @PathVariable String uuid) {
    	Restaurant restaurant = restaurantService.findByUUID(uuid);
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("dishes", restaurant.getDishes());
        model.addAttribute("showForm", "false");
        return "admin/restaurant";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
    	Restaurant restaurant = new Restaurant();
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("showForm", "true");
        return "admin/restaurant";
    }
   
    @RequestMapping(value = "/edit/{uuid}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable String uuid) {
    	Restaurant restaurant = restaurantService.findByUUID(uuid);
    	model.addAttribute("restaurant", restaurant);
        model.addAttribute("showForm", "true");
        model.addAttribute("editForm", "true");
    	return "admin/restaurant";
    }
    
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public String saveOrUpdate(Model model, Restaurant restaurant) {
    	restaurantService.saveOrUpdate(restaurant);
        model.addAttribute("saved", "success");
        return "redirect:../restaurants";
    }
    
    @RequestMapping(value = "/delete/{uuid}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable String uuid) {
    	restaurantService.delete(uuid);
        model.addAttribute("deleted", "success");
        List<Restaurant> restaurants = restaurantService.list();
        model.addAttribute("restaurants", restaurants);
        return "admin/restaurants";
    }
}
