package com.t3h.module2.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.t3h.module2.demo.Model.Product;

@RestController
public class ProductController {

    @Autowired
    private SpringTemplateEngine templateEngine; // Inject Thymeleaf's template engine
    
    @GetMapping("/api/items")
    public Product displayItems(
        @RequestParam String name,
        @RequestParam String category,
        @RequestParam Double price){

        Product product = new Product(name, category, price);

        return product;
    }

}