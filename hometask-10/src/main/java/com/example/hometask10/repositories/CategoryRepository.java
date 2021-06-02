package com.example.hometask10.repositories;

import com.example.hometask10.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByNameEquals(String name);

}
