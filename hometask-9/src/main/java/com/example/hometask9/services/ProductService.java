package com.example.hometask9.services;

import com.example.hometask9.dto.ProductDTO;
import com.example.hometask9.errors.exceptions.ResourceNotFoundException;
import com.example.hometask9.models.Product;
import com.example.hometask9.repositories.ProductRepository;
import com.example.hometask9.services.specification.ProductSpecification;
import com.example.hometask9.services.utils.DTOtoModelConverter;
import com.example.hometask9.services.utils.ModelToDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;


    public Page<ProductDTO> findAllProducts(Map<String, String> params) {
        Specification<Product> specification = ProductSpecification.build(params);
        Integer pageNumber = Integer.parseInt(params.getOrDefault("page", "1"));
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        Integer itemsOnPage = Integer.parseInt(params.getOrDefault("items-on-page", "5"));
        Pageable pageable = PageRequest.of(pageNumber - 1, itemsOnPage);
        return productRepository
                .findAll(specification, pageable)
                .map(ModelToDTOConverter::modelToDTO);

    }

    public ProductDTO save(ProductDTO productDTO) {
        var categoryName = productDTO.getCategoryName();
        var product = DTOtoModelConverter.DTOtoModel(productDTO,
                categoryService.getCategoryByName(categoryName));
        return ModelToDTOConverter.modelToDTO(productRepository.save(product));
    }

    public void removeProductById(Long id) {
        productRepository.deleteById(id);
    }

    public ProductDTO findById(Long id) {
        var product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ResourceNotFoundException(
                    String.format("No such product with id = %s", id));
        }
        return ModelToDTOConverter.modelToDTO(product.get());
    }
}
