package com.t3h.module2.demo.Model;

import java.util.List;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                   // Generates getters, setters, toString, equals, hashCode
@AllArgsConstructor     // Generates constructor with all fields
@NoArgsConstructor      // Generates no-args constructor (needed for Jackson)

public class Product {
    @Size(min = 5, max = 50, message = "Product ID must be between 5 and 50 characters")
    String productID;

    @Size(min = 50, message = "Name must have at least 50 characters")
    String name;

    @NotNull(message = "Category cannot be null")
    String category;
    
    @NotBlank(message = "Description cannot be blank")
    String description;

    @DecimalMin(value = "0.1", inclusive = true, message = "Price must be at least 0.1")
    @DecimalMax(value = "100.0", inclusive = true, message = "Price must be at most 100")
    Double price;
    
    @NotNull(message = "Tags cannot be null")
    @Size(min = 1, message = "At least one tag is required")
    List<String> tags;
}
