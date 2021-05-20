package com.example.hometask8.services.spec;

import com.example.hometask8.models.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author antonkuznetsov
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductSpec {

    public static Specification<Product> nameEq(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }

//    public static Specification<Product> nameLike(String name) {
//        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), name);
//    }

    public static Specification<Product> priceMoreThan(Integer lowLimit) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("price"), lowLimit);
    }
    public static Specification<Product> priceLessThan(Integer upLimit) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("price"), upLimit);
    }
}
