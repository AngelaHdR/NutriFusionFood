package com.fpmislata.NutriFusionFood.persistance.dao;

import java.util.List;

public interface RecipeDao {
    public List<RecipeEntity> findAllRecipe();
    public RecipeEntity findByIdRecipe(Integer id);
    public RecipeEntity delete();
    public RecipeEntity update();
    public List<RecipeEntity> findByCategory();
}
