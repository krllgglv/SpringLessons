package com.example.hometask9.controllers;


import com.example.hometask9.dto.CategoryDTO;
import com.example.hometask9.models.Category;
import com.example.hometask9.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public Category addProduct(@RequestBody Category category) {
        return categoryService.save(category);
    }


    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.findAllProducts();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);

    }


    @DeleteMapping("/{id}")
    public void removeProductById(@PathVariable Long id) {
        categoryService.removeProductById(id);
    }


}
