package com.fpmislata.NutriFusionFood.domain.service.impl;

import com.fpmislata.NutriFusionFood.common.container.UserIoC;
import com.fpmislata.NutriFusionFood.common.exceptions.ServiceException;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.service.RecipeService;
import com.fpmislata.NutriFusionFood.persistance.repository.RecipeRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.UserRepository;

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
        Recipe recipe = this.recipeRepository.findByIdRecipe(id);
        if (recipe==null){
            throw new ServiceException("There is no recipe with id " + id);
        }
        return recipe;
    }

    @Override
    public void delete(Integer id) {
        recipeRepository.delete(id);
    }

    @Override
    public void insert(Recipe recipe) {
        List<Recipe> recipeList = recipeRepository.findByNutritionist(recipe.getUser().getId());
        for (Recipe recipe1:recipeList) {
            if (recipe.getName().equals(recipe1.getName())) {
                throw new ServiceException("You already have a recipe with this name");
            }
        }
        recipeRepository.insert(recipe);
    }

    @Override
    public List<Recipe> findByCategory(Integer categoryId) {
        return this.recipeRepository.findByCategory(categoryId);
    }

    @Override
    public List<Recipe> findByNutritionist(Integer nutritionistId) {
        return this.recipeRepository.findByNutritionist(nutritionistId);
    }


}
