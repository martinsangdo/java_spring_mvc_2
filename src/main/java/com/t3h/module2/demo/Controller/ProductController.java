package com.t3h.module2.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.t3h.module2.demo.Model.Product;
import com.t3h.module2.demo.Model.Recipe;
import com.t3h.module2.demo.Service.ExternalApiService;

import jakarta.validation.Valid;

@RestController
public class ProductController {
    @Autowired
    ExternalApiService externalApiService;

    @Autowired
    private SpringTemplateEngine templateEngine; // Inject Thymeleaf's template engine
    //5.1
    @GetMapping("/api/items")
    public Product displayItems(
        @RequestParam String name,
        @RequestParam String category,
        @RequestParam Double price){

        Product product = new Product("test", name, category, "test", price, new ArrayList<>());

        return product;
    }
    //6.2
    @PostMapping("/api/product")
    public ResponseEntity<@Valid Product> createNewProduct(@Valid @RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    //get data and response as JSON
    //7.2
    @GetMapping("/api/recipes")
    public ResponseEntity<JsonNode> getRecipes() {
        try {
            JsonNode data = externalApiService.fetchDataFromExternalApi("https://dummyjson.com/recipes");
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    //display data to UI page
    //7.3
    @GetMapping(value = "/recipes_ui", produces = MediaType.TEXT_HTML_VALUE)
    public String display7_3() {
        Context context = new Context();
        try {
            JsonNode data = externalApiService.fetchDataFromExternalApi("https://dummyjson.com/recipes");
            ObjectMapper mapper = new ObjectMapper();
            List<Recipe> jsonList = mapper.convertValue(data.get("recipes"), ArrayList.class);
            context.setVariable("recipes", jsonList);
        } catch (Exception e){
            
        }
        return templateEngine.process("unit7_3", context);
    }
    //7.4
    @GetMapping(value = "/recipes_ui_new", produces = MediaType.TEXT_HTML_VALUE)
    public String display7_4() {
        Context context = new Context();
        try {
            JsonNode data = externalApiService.fetchDataFromExternalApi("https://dummyjson.com/recipes");
            ObjectMapper mapper = new ObjectMapper();
            List<Recipe> jsonList = mapper.convertValue(data.get("recipes"), ArrayList.class);
            context.setVariable("recipes", jsonList);
        } catch (Exception e){
            
        }
        return templateEngine.process("unit7_4", context);
    }
}