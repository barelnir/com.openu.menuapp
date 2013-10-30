package com.openu.menuapp.controller;

import com.openu.menuapp.entity.Product;
import com.openu.menuapp.service.ProductService;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {
/*
    @Autowired
    private ProductService baseEntityService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showProductForm(Model model) {
        model.addAttribute("product",new Product());
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String save( Model model, Product product) {
    	baseEntityService.saveOrUpdate(product);
        model.addAttribute("saved", "success");
        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Model model, Product product) {
        List<Product> pruducts = baseEntityService.findByCriteria(Restrictions.like("productName", product.getProductName(), MatchMode.START));
        model.addAttribute("products", pruducts);
        model.addAttribute("search", true);
        return "index";
    }

    @RequestMapping(value = "/edit/{uuid}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable String uuid) {
        Product product = baseEntityService.findByUUID(uuid);
        model.addAttribute("product", product);
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update( Model model, Product product) {
    	baseEntityService.saveOrUpdate(product);
        model.addAttribute("saved", "success");
        return "update";
    }
    @RequestMapping(value = "/delete/{uuid}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable String uuid) {
    	baseEntityService.delete(uuid);
        model.addAttribute("deleted", "success");
        model.addAttribute("product", new Product());
        return "index";
    }
*/
}
