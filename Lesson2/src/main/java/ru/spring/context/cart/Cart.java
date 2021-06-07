package ru.spring.context.cart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.spring.context.product.Product;
import ru.spring.context.product.ProductRepository;

import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addItem(String[] parameters) {
        productRepository.getProductList().add(
                new Product(Long.parseLong(parameters[1]),
                        parameters[2],
                        Double.parseDouble(parameters[3])));
    }

    public void removeItem(int index) {
      productRepository.getProductList().remove(index);
    }

    public void removeItem(String[] parameters) {
        productRepository.getProductList().remove(
                new Product(Long.parseLong(parameters[1]),
                        parameters[2],
                        Double.parseDouble(parameters[3])));
            }

    public List<Product> getproductList() {
        return productRepository.getProductList();
    }


}
