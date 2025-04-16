package com.parth.productapp.category;

import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {

    Page<Category> findAll(int page);

    void createCategory(Category category);

    Category getCategoryById(Long id);

    boolean deleteCategoryById(Long id);

    boolean updatedCategory(Long id, Category updatedCategory);
}
