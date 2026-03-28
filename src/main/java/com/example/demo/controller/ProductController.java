package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // CREATE
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    // READ ALL
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable long id,
            @Valid @RequestBody Product productDetails) {

        return productRepository.findById(id).map(existingProduct -> {

            existingProduct.setProductName(productDetails.getProductName());
            existingProduct.setProductDescription(productDetails.getProductDescription());
            existingProduct.setProductPrice(productDetails.getProductPrice());
            existingProduct.setProductDiscount(productDetails.getProductDiscount());
            existingProduct.setStockQuantity(productDetails.getStockQuantity());

            Product updatedProduct = productRepository.save(existingProduct);
            return ResponseEntity.ok(updatedProduct);

        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getByName(@PathVariable String name) {
        return productRepository.findByProductName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/exists/{name}")
    public ResponseEntity<Boolean> checkProduct(@PathVariable String name) {
        return ResponseEntity.ok(productRepository.existsByProductName(name));
    }
}