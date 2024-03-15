package com.fpmislata.NutriFusionFood.domain.service;

import com.fpmislata.NutriFusionFood.domain.entity.Recipe;

import java.util.List;

public interface RecipeService {
    public List<Recipe> findAllRecipe();
    public Recipe findByIdRecipe(Integer id);
    public Recipe delete();
    public Recipe update();
    public List<Recipe> findByCategory();
}
