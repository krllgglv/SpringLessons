package ru.kgogolev.hometask3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kgogolev.hometask3.dto.Product;
import ru.kgogolev.hometask3.repository.ProductRepository;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.BlockingDeque;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public BlockingDeque<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(Long id) {
    Optional<Product> product = productRepository.getProductById(id);
        if (product.isPresent()){
            return product.get();
        }
        throw new NoSuchElementException("No such product with id = " + id);
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);

    }
}
