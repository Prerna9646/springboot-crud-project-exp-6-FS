package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "product_table")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @NotBlank(message = "Product name is required")
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")
    private String productName;

    @NotBlank(message = "Product description is required")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String productDescription;

    @NotNull(message = "Product price is required")
    @Positive(message = "Product price must be greater than 0")
    private Double productPrice;

    @NotNull(message = "Product discount is required")
    @Min(value = 0, message = "Discount cannot be negative")
    @Max(value = 100, message = "Discount cannot be more than 100 percent")
    private Integer productDiscount;

    @NotNull(message = "Stock quantity is required")
    @Min(value = 0, message = "Stock cannot be negative")
    private Integer stockQuantity;
}