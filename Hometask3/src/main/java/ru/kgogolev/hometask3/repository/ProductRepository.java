package ru.kgogolev.hometask3.repository;

import org.springframework.stereotype.Repository;
import ru.kgogolev.hometask3.dto.Product;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Repository
public class ProductRepository {
    private BlockingDeque<Product> products;

    @PostConstruct
    private void init() {
        products = new LinkedBlockingDeque();
        products.addAll(List.of(
                new Product(1L, "Product1", 12.5),
                new Product(2L, "Product2", 10.0),
                new Product(3L, "Product3", 50.8),
                new Product(4L, "Product4", 1.0),
                new Product(5L, "Product5", 6.32)
        ));
    }

    public BlockingDeque<Product> getAllProducts() {
        return products;
    }
    public Optional<Product> getProductById(Long id){
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }
    public void addProduct(Product product){
        products.add(product);

    }

}
