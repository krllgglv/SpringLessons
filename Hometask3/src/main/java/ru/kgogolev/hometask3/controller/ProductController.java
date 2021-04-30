package ru.kgogolev.hometask3.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kgogolev.hometask3.dto.Product;
import ru.kgogolev.hometask3.service.ProductService;

import java.util.concurrent.BlockingDeque;

@Controller
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @GetMapping("show_products")
    public String showProducts(Model model) {
        BlockingDeque<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";

    }

    @GetMapping("add_product")
    public String createProduct() {
        return "add_product";
    }

    @PostMapping("add_product")
    public String createProduct(@RequestParam Long id,
                                @RequestParam String name,
                                @RequestParam Double price,
                                Model model
    ) {
        Product product = new Product(id, name, price);
        productService.addProduct(product);
        return "redirect:/products/success";
    }

    @GetMapping("index")
    public String showMainPage() {

        return "index";

    }
    @GetMapping("success")
    public String showSuccessPage() {

        return "success";

    }

}
