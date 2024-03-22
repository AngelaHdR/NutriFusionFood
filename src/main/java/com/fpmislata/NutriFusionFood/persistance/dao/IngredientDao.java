package com.fpmislata.NutriFusionFood.persistance.dao;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;

import java.util.List;

public interface IngredientDao {
    public List<IngredientEntity> findAllIngredient();
    public IngredientEntity findByIdIngredient(Integer id);
    public List<IngredientEntity> findByRecipe(Integer recipeId);
    public void insert(IngredientEntity ingredientEntity);
    public void delete(Integer id);

}
