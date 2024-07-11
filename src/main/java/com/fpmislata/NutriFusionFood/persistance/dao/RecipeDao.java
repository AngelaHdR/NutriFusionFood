package com.fpmislata.NutriFusionFood.persistance.dao;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;

import java.util.List;

public interface RecipeDao {
    public List<RecipeEntity> findAllRecipe();
    public RecipeEntity findByIdRecipe(Integer id);
    public void delete(Integer id);
    public void insert(RecipeEntity recipeEntity, List<IngredientEntity> ingredientEntityList, List<ToolEntity> toolEntityList);
    public void update(RecipeEntity recipeEntity, List<IngredientEntity> ingredientEntityList, List<ToolEntity> toolEntityList);
    public List<RecipeEntity> findByCategory(Integer categoryId);
    public List<RecipeEntity> findByNutritionist(Integer nutritionistId);
    public RecipeEntity findByNameAndNutritionist(String name, int userId);
    public void addFavorites(RecipeEntity recipeEntity, Integer userId);
    public void removeFavorites(RecipeEntity recipeEntity, Integer userId);
    public List<RecipeEntity> findFavoritesByUser(Integer userId);
}
