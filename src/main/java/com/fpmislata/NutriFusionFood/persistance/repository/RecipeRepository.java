package com.fpmislata.NutriFusionFood.persistance.repository;

import com.fpmislata.NutriFusionFood.domain.entity.Recipe;

import java.util.List;

public interface RecipeRepository {
    public List<Recipe> findAllRecipe();
    public Recipe findByIdRecipe(Integer id);
    public void delete(Integer id);
    public Recipe update();
    public void insert(Recipe recipe);
    public List<Recipe> findByCategory(Integer categoryId);
}
