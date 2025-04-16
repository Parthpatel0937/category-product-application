package com.parth.productapp.category.impl;

import com.parth.productapp.category.Category;
import com.parth.productapp.category.CategoryRepository;
import com.parth.productapp.category.CategoryService;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {


    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Page<Category> findAll(int page){
        return categoryRepository.findAll(PageRequest.of(page,5));
    }

    @Override
    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCategoryById(Long id){
        try{
            categoryRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updatedCategory(Long id, Category updatedCategory){

        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            category.setName(updatedCategory.getName());
            category.setDescription(updatedCategory.getDescription());
            categoryRepository.save(category);
                return true;
        }
        return false;
    }
}
