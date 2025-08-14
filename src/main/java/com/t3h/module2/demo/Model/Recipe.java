package com.t3h.module2.demo.Model;

import java.util.List;

import lombok.Data;

@Data
public class Recipe {
    private int id;
    private String name;
    private String image;   //image link
    private String rating;
    private List<String> ingredients;
}
