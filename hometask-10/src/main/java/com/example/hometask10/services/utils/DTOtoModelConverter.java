package com.example.hometask10.services.utils;

import com.example.hometask10.dto.ProductDTO;
import com.example.hometask10.models.Category;
import com.example.hometask10.models.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DTOtoModelConverter {


    public static Product DTOtoModel(ProductDTO productDTO, Category category) {
        var product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return product;
    }

}
