package com.fpmislata.NutriFusionFood.persistance.repository;

import com.fpmislata.NutriFusionFood.domain.entity.Recipe;

import java.util.List;

public interface RecipeRepository {
    //CRUD
    public void insert(Recipe recipe);
    public void update(Recipe recipe);
    public List<Recipe> findAllRecipe();
    public Recipe findByIdRecipe(Integer id);
    public void delete(Integer id);

    //Filters
    public List<Recipe> findByCategory(Integer categoryId);
    public List<Recipe> findByNutritionist(Integer nutritionistId);
    public Recipe findByNameAndNutritionist(String name, int userId);
    public List<Recipe> findByNoLactose();
    public List<Recipe> findByNoGluten();
    public List<Recipe> findByTimeMax(Integer timeMax);
    public List<Recipe> findByTimeMin(Integer timeMin);
    public void addFavorites(Recipe recipe, Integer userId);
    public void removeFavorites(Recipe recipe, Integer userId);
    public List<Recipe> findFavoritesByUser(Integer userId);
}
