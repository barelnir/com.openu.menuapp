/**
 * menuapp
 * 30 баеч 2013 09:50:50
 * RestaurantController.java
 *
 * Lior Negrin ID: 040829780
 * Nir Barel ID: 032483372
 */
package com.openu.menuapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.openu.menuapp.entity.AdditionalOption;
import com.openu.menuapp.entity.Address;
import com.openu.menuapp.entity.Dish;
import com.openu.menuapp.entity.Order;
import com.openu.menuapp.service.DishService;
import com.openu.menuapp.service.OrderService;
import com.openu.menuapp.utils.convertors.AdditionalOptionConvertor;
import com.openu.menuapp.utils.convertors.DishConvertor;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

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
    private DishService dishService;
	
	@Autowired
    private OrderService orderService;

	 @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
	 public String loadOrderPage(Model model, @PathVariable String uuid) {
		 	Dish dish = dishService.findByUUID(uuid);
	        model.addAttribute("dish",dish);
	        List<AdditionalOption> additionalOptions = new ArrayList<AdditionalOption>(dish.getAdditionalOptions());
	        model.addAttribute("availableAdditionalOptions",additionalOptions);
	        model.addAttribute("order",new Order(dish));
	        return "order";
	 }

	 @RequestMapping(value = "/create", method = RequestMethod.POST)
	    public String save(Model model, @ModelAttribute Order order) {
		 order.setDeliveryAddress(new Address("","Tel Aviv666666","Main",6,4,"CP",5,"2",323232));
		 order.setDeliveryTime(new Date());
		 orderService.saveOrUpdate(order);
	     model.addAttribute("saved", "success");
	     return "redirect:../restaurant/" + order.getDish().getRestaurant().getUuid();
	    }
	 
}
