package ru.kgogolev.homework7.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kgogolev.homework7.model.Product;
import ru.kgogolev.homework7.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll(Integer moreExpensiveThan, Integer cheaperThan) {
        if (moreExpensiveThan != null) {
            if (cheaperThan != null) {
                if (cheaperThan < moreExpensiveThan) {
                    throw new IllegalStateException("Upper limit could not be less lower limit!!");
                }
                return productRepository.findAllByPriceBetween(moreExpensiveThan, cheaperThan);
            }
            return productRepository.findAllByPriceGreaterThan(moreExpensiveThan);
        } else if (cheaperThan != null) {
            return productRepository.findAllByPriceLessThan(cheaperThan);
        }

        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
