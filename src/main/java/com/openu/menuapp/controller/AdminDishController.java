/**
 * menuapp
 * 28 баеч 2013 21:25:47
 * IndexController.java
 *
 * Lior Negrin ID: 040829780
 * Nir Barel ID: 032483372
 */
package com.openu.menuapp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.openu.menuapp.entity.AdditionalOption;
import com.openu.menuapp.entity.Dish;
import com.openu.menuapp.entity.Restaurant;
import com.openu.menuapp.service.AdditionalOptionService;
import com.openu.menuapp.service.DishService;
import com.openu.menuapp.service.RestaurantService;
import com.openu.menuapp.utils.convertors.AdditionalOptionConvertor;
import com.openu.menuapp.utils.convertors.DishConvertor;

@Controller
@RequestMapping(value = "/admin/restaurant/dish")
public class AdminDishController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(AdditionalOption.class, additionalOptionConvertor);
		binder.registerCustomEditor(Dish.class, dishConvertor);
	}

	@Autowired
	private AdditionalOptionConvertor additionalOptionConvertor;
	
	@Autowired
	private DishConvertor dishConvertor;
	
	@Autowired
    private RestaurantService restaurantService;
	
	@Autowired
    private DishService dishService;
	
	@Autowired
    private AdditionalOptionService additionalOptionService;

	@RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public String load(Model model, @PathVariable String uuid) {
    	Dish dish = dishService.findByUUID(uuid);
        model.addAttribute("dish", dish);
        model.addAttribute("availableAdditionalOptions", dish.getAdditionalOptions());
        model.addAttribute("showForm", "false");
        return "admin/dish";
    }
    
    @RequestMapping(value = "/add/{restaurant_uuid}", method = RequestMethod.GET)
    public String add(Model model, @PathVariable String restaurant_uuid) {
    	Dish dish = new Dish();
    	Restaurant restaurant = restaurantService.findByUUID(restaurant_uuid);
    	dish.setRestaurant(restaurant);
        model.addAttribute("dish", dish);
        model.addAttribute("showForm", "true");
        return "admin/dish";
    }
   
    @RequestMapping(value = "/edit/{uuid}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable String uuid) {
    	Dish dish = dishService.findByUUID(uuid);
    	model.addAttribute("dish", dish);
        model.addAttribute("showForm", "true");
        model.addAttribute("editForm", "true");
    	return "admin/dish";
    }
    
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public String saveOrUpdate(Model model, Dish dish) {
    	dishService.saveOrUpdate(dish);
        model.addAttribute("saved", "success");
        return "redirect:../" + dish.getRestaurant().getUuid();
    }
    
    @RequestMapping(value = "/delete/{uuid}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable String uuid) {
    	Dish dish = dishService.findByUUID(uuid);
    	Restaurant restaurant = dish.getRestaurant();
    	restaurant.getDishes().remove(dish);
    	restaurantService.saveOrUpdate(restaurant);
    	//dish.setRestaurant(null);
    	//dishService.saveOrUpdate(dish);
    	//dishService.delete(uuid);
        model.addAttribute("deleted", "success");
        List<Dish> dishes = new ArrayList<Dish>(restaurant.getDishes());
        model.addAttribute("dishes", dishes);
        return "redirect:../../" + restaurant.getUuid();
    }
}
