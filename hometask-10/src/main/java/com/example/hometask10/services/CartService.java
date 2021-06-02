package com.example.hometask10.services;

import com.example.hometask10.components.Cart;
import com.example.hometask10.dto.CartDTO;
import com.example.hometask10.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
@RequiredArgsConstructor
public class CartService {
    private final Cart cart;
    private final ProductService productService;

    public void addProductToCart(Long id) {
        cart.addProductToCart(productService.findById(id));
    }


    public void removeProductFromCart (Long id) {
        cart.addProductToCart(productService.findById(id));
    }

    public CartDTO getCart () {
        return new CartDTO(cart.getSum(), Collections.unmodifiableList(cart.getProducts()));

    }
}
