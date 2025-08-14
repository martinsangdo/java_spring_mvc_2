package com.t3h.module2.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                   // Generates getters, setters, toString, equals, hashCode
@AllArgsConstructor     // Generates constructor with all fields
@NoArgsConstructor      // Generates no-args constructor (needed for Jackson)

public class Product {
    String name;
    String category;
    Double price;
}
