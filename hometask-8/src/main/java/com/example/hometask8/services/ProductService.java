package com.example.hometask8.services;

import com.example.hometask8.models.Product;
import com.example.hometask8.repositories.ProductRepository;
import com.example.hometask8.services.spec.ProductSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public Page<Product> findAllProducts(int page, int size) {

        return productRepository.findAll(PageRequest.of(page, size));
    }

    public Page<Product> findAllProducts(Map<String, String> params) {
        final Specification<Product> specification = params.entrySet().stream()
                .filter(it -> StringUtils.hasText(it.getValue()))
                .map(it -> {
                    if ("name".equals(it.getKey())) {
                        return ProductSpec.nameEq(it.getValue());
                    }
                    if ("upLimit".equals(it.getKey())) {
                        return ProductSpec.priceLessThan(Integer.parseInt(it.getValue()));
                    }
                    if ("lowLimit".equals(it.getKey())) {
                        return ProductSpec.priceMoreThan(Integer.parseInt(it.getValue()));
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .reduce(Specification::and)
                .orElse(null);
        Integer pageNumber = Integer.parseInt(params.getOrDefault("page", "1"));
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        Pageable pageable = PageRequest.of(pageNumber - 1, 5);
        return productRepository.findAll(specification, pageable);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void removeProductById(Long id) {
        productRepository.deleteById(id);
    }
}
