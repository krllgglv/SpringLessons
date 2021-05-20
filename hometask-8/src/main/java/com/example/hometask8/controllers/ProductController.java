package com.example.hometask8.controllers;

import com.example.hometask8.models.Product;
import com.example.hometask8.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }


    @GetMapping
    public Page<Product> getAllProducts(@RequestParam Map<String, String> params) {
        return productService.findAllProducts(params);
    }


    @DeleteMapping("/{id}")
    public void removeProductById(@PathVariable Long id) {
        productService.removeProductById(id);
    }
}
