package ru.kgogolev.homework7.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kgogolev.homework7.model.Product;
import ru.kgogolev.homework7.service.ProductService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @GetMapping
    public List<Product> findAllProducts(@RequestParam(name = "min", required = false)
                                                 Integer moreExpensiveThan,
                                         @RequestParam(name = "max", required = false)
                                                 Integer cheaperThan) {
        return productService.findAll(moreExpensiveThan, cheaperThan);
    }

    @PostMapping("/add")
    public Product add(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
