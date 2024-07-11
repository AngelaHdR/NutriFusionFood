package com.fpmislata.NutriFusionFood.persistance.repository;

import com.fpmislata.NutriFusionFood.domain.entity.Recipe;

import java.util.List;

public interface RecipeRepository {
    public List<Recipe> findAllRecipe();
    public Recipe findByIdRecipe(Integer id);
    public void delete(Integer id);
    public void insert(Recipe recipe);
    public void update(Recipe recipe);
    public List<Recipe> findByCategory(Integer categoryId);
    public List<Recipe> findByNutritionist(Integer nutritionistId);
    public Recipe findByNameAndNutritionist(String name, int userId);

    public void addFavorites(Recipe recipe, Integer userId);
    public void removeFavorites(Recipe recipe, Integer userId);
    public List<Recipe> findFavoritesByUser(Integer userId);
}
