package com.openu.menuapp.controller;

import com.openu.menuapp.entity.Product;
import com.openu.menuapp.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showUserForm(Model model) {
        model.addAttribute("product",new Product());
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveUser( Model model, Product product) {
        productService.saveOrUpdate(product);
        model.addAttribute("saved", "success");
        return "index";
    }

    /*@RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchUser(Model model, Product product) {
        List<Product> users = productService.findByCriteria(product.getUuid());
        model.addAttribute("users", users);
        model.addAttribute("search", true);
        return "index";
    }*/

    @RequestMapping(value = "/edit/{productId}", method = RequestMethod.GET)
    public String updateUser(Model model, @PathVariable String productId) {
        Product product = productService.findByUUID(productId);
        model.addAttribute("product", product);
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser( Model model, Product product) {
        productService.saveOrUpdate(product);
        model.addAttribute("saved", "success");
        return "update";
    }
    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
    public String deleteProduct(Model model, @PathVariable String productId) {
        productService.delete(productId);
        model.addAttribute("deleted", "success");
        model.addAttribute("product", new Product());
        return "index";
    }

}
