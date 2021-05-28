package com.example.hometask9.repositories;

import com.example.hometask9.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByNameEquals(String name);

}
