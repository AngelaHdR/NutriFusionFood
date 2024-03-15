package com.fpmislata.NutriFusionFood.persistance.repository;

import com.fpmislata.NutriFusionFood.domain.entity.Recipe;

import java.util.List;

public interface RecipeRepository {
    public List<Recipe> findAllRecipe();
    public Recipe findByIdRecipe(Integer id);
    public Recipe delete();
    public Recipe update();
    public List<Recipe> findByCategory();
}
