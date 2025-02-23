package com.fpmislata.NutriFusionFood.domain.service;

import com.fpmislata.NutriFusionFood.domain.entity.Recipe;

import java.util.List;

public interface RecipeService {
    public List<Recipe> findAllRecipe();
    public Recipe findByIdRecipe(Integer id);
    public void delete(Integer id);
    public void insert(Recipe recipe);
    public void update(Recipe recipe);
    public List<Recipe> findByCategory(Integer categoryId);
    public List<Recipe> findByNutritionist(Integer nutritionistId);
    public List<Recipe> findByAllergen(String allergen);
    public List<Recipe> findByTime(Integer timeMin, Integer timeMax);
    public List<Integer> findMaxMinTime();
    public void modifyFavorites(Integer recipeId, Boolean status, Integer userId);
}
