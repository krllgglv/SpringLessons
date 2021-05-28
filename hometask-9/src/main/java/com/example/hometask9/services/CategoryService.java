package com.example.hometask9.services;


import com.example.hometask9.dto.CategoryDTO;
import com.example.hometask9.errors.exceptions.ResourceNotFoundException;
import com.example.hometask9.models.Category;
import com.example.hometask9.repositories.CategoryRepository;
import com.example.hometask9.services.utils.ModelToDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public CategoryDTO findById(Long id) {
        var category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new ResourceNotFoundException(
                    String.format("No such category with id = %s", id));
        }
        return ModelToDTOConverter.modelToDTO(category.get());
    }

    public void removeProductById(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<CategoryDTO> findAllProducts() {
        var allCategories = categoryRepository.findAll();
        return allCategories.stream()
                .map(ModelToDTOConverter::modelToDTO)
                .collect(Collectors.toUnmodifiableList());

    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.findByNameEquals(name);
    }
}
