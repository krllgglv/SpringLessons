package com.example.hometask10.controllers;


import com.example.hometask10.dto.CartDTO;
import com.example.hometask10.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/{id}")
    public void addProduct(@PathVariable Long id) {
        cartService.addProductToCart(id);
    }


    @GetMapping
    public CartDTO getCart() {
        return cartService.getCart();
    }


}
