package com.fpmislata.NutriFusionFood.domain.service.impl;

import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.service.RecipeService;
import com.fpmislata.NutriFusionFood.persistance.repository.RecipeRepository;

import java.util.List;

public class RecipeServiceImpl implements RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> findAllRecipe() {

        return this.recipeRepository.findAllRecipe();

    }

    @Override
    public Recipe findByIdRecipe(Integer id) {
        return this.recipeRepository.findByIdRecipe(id);
    }

    @Override
    public void delete(Integer id) {
        recipeRepository.delete(id);
    }

    @Override
    public void insert(Recipe recipe) {
        recipeRepository.insert(recipe);
    }

    @Override
    public List<Recipe> findByCategory(Integer categoryId) {
        return this.recipeRepository.findByCategory(categoryId);
    }


}
