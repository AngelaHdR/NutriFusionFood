package com.fpmislata.NutriFusionFood.persistance.repository;

import java.util.List;

public interface RecipeRepository {
    public List<Recipe> findAllRecipe();
    public Recipe findByIdRecipe(Integer id);
    public Recipe delete();
    public Recipe update();
    public List<Recipi> findByCategory();
}
