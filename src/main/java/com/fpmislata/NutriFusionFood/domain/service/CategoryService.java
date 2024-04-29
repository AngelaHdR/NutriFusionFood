package com.fpmislata.NutriFusionFood.domain.service;

import com.fpmislata.NutriFusionFood.domain.entity.Category;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;

import java.util.List;

public interface CategoryService {
    public List<Category> findAllCategory();
    public Category findByIdCategory(Integer id);
    public List<Recipe> findRecipeByCategory(Integer id);
}
