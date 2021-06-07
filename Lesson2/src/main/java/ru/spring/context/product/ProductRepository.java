package ru.spring.context.product;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;


    @PostConstruct
    private void initList(){
        products =  new ArrayList<>(
                List.of(
                        new Product(1L, "Product1", 100.2),
                        new Product(2L, "Product2", 12.5),
                        new Product(3L, "Product3", 10.8),
                        new Product(4L, "Product4", 122.0),
                        new Product(5L, "Product5", 2000.0)
                )
        );
    }
    public List<Product> getProductList() {
        return products;
    }


}
