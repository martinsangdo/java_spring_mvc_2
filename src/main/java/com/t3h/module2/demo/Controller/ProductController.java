package com.t3h.module2.demo.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.t3h.module2.demo.Model.Product;

import jakarta.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    private SpringTemplateEngine templateEngine; // Inject Thymeleaf's template engine

    @GetMapping("/api/items")
    public Product displayItems(
        @RequestParam String name,
        @RequestParam String category,
        @RequestParam Double price){

        Product product = new Product("test", name, category, "test", price, new ArrayList<>());

        return product;
    }

    @PostMapping("/api/product")
    public ResponseEntity<@Valid Product> createNewProduct(@Valid @RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

}