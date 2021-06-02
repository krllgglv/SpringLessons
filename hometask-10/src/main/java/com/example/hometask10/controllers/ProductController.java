package com.example.hometask10.controllers;

import com.example.hometask10.dto.ProductDTO;
import com.example.hometask10.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @GetMapping
    public Page<ProductDTO> getAllProducts(@RequestParam Map<String, String> params) {
        return productService.findAllProducts(params);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void removeProductById(@PathVariable Long id) {
        productService.removeProductById(id);
    }

}
