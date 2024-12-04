package com.example.lab11w7day4.Repository;


import com.example.lab11w7day4.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoryById(Integer id);

    Category findCategoryByName(String name);
}
