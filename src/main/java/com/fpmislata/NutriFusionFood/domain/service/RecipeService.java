package com.fpmislata.NutriFusionFood.domain.service;

import java.util.List;

public interface RecipeService {
    public List<Recipe> findAllRecipe();
    public Recipe findByIdRecipe(Integer id);
    public Recipe delete();
    public Recipe update();
    public List<Recipi> findByCategory();
}
