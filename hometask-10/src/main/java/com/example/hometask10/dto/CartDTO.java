package com.example.hometask10.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartDTO {
    private Integer sum;
    private List<ProductDTO> products;

}
