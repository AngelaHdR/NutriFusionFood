package com.fpmislata.NutriFusionFood.domain.service.impl;

import com.fpmislata.NutriFusionFood.domain.entity.Category;
import com.fpmislata.NutriFusionFood.domain.service.CategoryService;
import com.fpmislata.NutriFusionFood.persistance.repository.CategoryRepository;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository=categoryRepository;
    }

    @Override
    public List<Category> findAllCategory() {
        return this.categoryRepository.findAllCategory();
    }

    @Override
    public Category findByIdCategory(Integer id) {
        return this.categoryRepository.findByIdCategory(id);
    }
}
