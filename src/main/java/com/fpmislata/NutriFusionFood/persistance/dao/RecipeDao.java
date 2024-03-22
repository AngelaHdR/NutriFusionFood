package com.fpmislata.NutriFusionFood.persistance.dao;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;

import java.util.List;

public interface RecipeDao {
    public List<RecipeEntity> findAllRecipe();
    public RecipeEntity findByIdRecipe(Integer id);
    public void delete(Integer id);
    public void insert(RecipeEntity recipeEntity);
    public List<RecipeEntity> findByCategory(Integer categoryId);
    public List<RecipeEntity> findByNutritionist(Integer nutritionistId);
}
