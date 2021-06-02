package com.example.hometask10.services.utils;

import com.example.hometask10.dto.CategoryDTO;
import com.example.hometask10.dto.ProductDTO;
import com.example.hometask10.models.Category;
import com.example.hometask10.models.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModelToDTOConverter {

    public static ProductDTO modelToDTO(Product product) {
        return new ProductDTO(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategory().getName());
    }

    public static CategoryDTO modelToDTO(Category category) {
        return new CategoryDTO(category.getId(),
                category.getName());
    }
}
