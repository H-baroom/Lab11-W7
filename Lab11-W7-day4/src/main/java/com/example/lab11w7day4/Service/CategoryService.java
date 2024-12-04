package com.example.lab11w7day4.Service;

import com.example.lab11w7day4.Api.ApiException;
import com.example.lab11w7day4.Model.Category;
import com.example.lab11w7day4.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Integer id,Category category) {
        Category updatCeategory = categoryRepository.findCategoryById(id);
        if (updatCeategory == null){
            throw new ApiException("Category not found");
        }
        updatCeategory.setName(category.getName());
        updatCeategory.setCategory_id(category.getCategory_id());
        categoryRepository.save(updatCeategory);
    }

    public void deleteCategory(Integer id) {
        Category oldCategory = categoryRepository.findCategoryById(id);
        if (oldCategory == null){
            throw new ApiException("Category not found");
        }
        categoryRepository.delete(oldCategory);
    }

    public Category getCategoryByName(String name){
        Category category = categoryRepository.findCategoryByName(name);
        if (category == null){
            throw new ApiException("Category not found");
        }
        return category;
    }
}
