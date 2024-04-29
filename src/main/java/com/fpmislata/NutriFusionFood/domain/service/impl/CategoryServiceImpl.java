package com.fpmislata.NutriFusionFood.domain.service.impl;

import com.fpmislata.NutriFusionFood.common.container.RecipeIoC;
import com.fpmislata.NutriFusionFood.domain.entity.Category;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.service.CategoryService;
import com.fpmislata.NutriFusionFood.persistance.repository.CategoryRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.RecipeRepository;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository=categoryRepository;
        this.recipeRepository= RecipeIoC.getRecipeRepository();
    }

    @Override
    public List<Category> findAllCategory() {
        return this.categoryRepository.findAllCategory();
    }

    @Override
    public Category findByIdCategory(Integer id) {
        return this.categoryRepository.findByIdCategory(id);
    }

    @Override
    public List<Recipe> findRecipeByCategory(Integer id) {
        return this.recipeRepository.findByCategory(id);
    }
}
