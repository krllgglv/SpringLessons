package com.example.hometask9.services.specification;

import com.example.hometask9.models.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Objects;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductSpecification {

    public static Specification<Product> nameEq(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }


    public static Specification<Product> priceMoreThan(Integer lowLimit) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("price"), lowLimit);
    }

    public static Specification<Product> priceLessThan(Integer upLimit) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("price"), upLimit);
    }

    public static Specification<Product> build(Map<String, String> params) {
        return params.entrySet().stream()
                .filter(it -> StringUtils.hasText(it.getValue()))
                .map(it -> {
                    if ("name".equals(it.getKey())) {
                        return ProductSpecification.nameEq(it.getValue());
                    }
                    if ("upLimit".equals(it.getKey())) {
                        return ProductSpecification.priceLessThan(Integer.parseInt(it.getValue()));
                    }
                    if ("lowLimit".equals(it.getKey())) {
                        return ProductSpecification.priceMoreThan(Integer.parseInt(it.getValue()));
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .reduce(Specification::and)
                .orElse(null);
    }
}
