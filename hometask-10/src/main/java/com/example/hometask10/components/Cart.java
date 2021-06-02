package com.example.hometask10.components;

import com.example.hometask10.dto.ProductDTO;
import com.example.hometask10.models.Product;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Data
public class Cart {
    private CopyOnWriteArrayList <ProductDTO> products;
    private int sum;

    @PostConstruct
    private void  init(){
        products = new CopyOnWriteArrayList<>();

    }

    public void addProductToCart (ProductDTO product){
        products.add(product);
        sum+=product.getPrice();
    }

    public void removeProductFromCart (ProductDTO product){
        products.remove(product);
        sum-=product.getPrice();

    }
}
