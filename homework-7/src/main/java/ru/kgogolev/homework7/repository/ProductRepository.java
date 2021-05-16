package ru.kgogolev.homework7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kgogolev.homework7.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceLessThan(Integer cheaperThan);
    List<Product> findAllByPriceGreaterThan(Integer moreExpensiveThan);
    List<Product> findAllByPriceBetween(Integer moreExpensiveThan, Integer cheaperThan);
}
