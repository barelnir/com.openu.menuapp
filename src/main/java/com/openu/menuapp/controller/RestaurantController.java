/**
 * menuapp
 * 30 баеч 2013 09:50:50
 * RestaurantController.java
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
@RequestMapping(value = "/restaurant")
public class RestaurantController {

	@Autowired
    private RestaurantService restaurantService;

	 @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
	 public String update(Model model, @PathVariable String uuid) {
	        Restaurant resturant = restaurantService.findByUUID(uuid);
	        model.addAttribute("resturant", resturant);
	        model.addAttribute("dishes",resturant.getDishes());
	        return "resturant";
	 }

}
