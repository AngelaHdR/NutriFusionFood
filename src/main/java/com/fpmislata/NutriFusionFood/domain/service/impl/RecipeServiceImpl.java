package com.fpmislata.NutriFusionFood.domain.service.impl;

import com.fpmislata.NutriFusionFood.common.Auth;
import com.fpmislata.NutriFusionFood.common.exceptions.BusinessException;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.entity.Tool;
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
        Recipe recipe = this.recipeRepository.findByIdRecipe(id);
        if (recipe==null){
            throw new BusinessException("There is no recipe with id " + id);
        }
        return recipe;
    }

    @Override
    public void delete(Integer id) {
        Recipe recipe = findByIdRecipe(id);
        if (recipe==null){
            throw new BusinessException("There is no recipe with id " + id);
        }
        if (recipe.getUser().getId()!= Auth.getUser().getId()){
            throw new BusinessException("This recipe is not from the correct user ");
        }
        recipeRepository.delete(id);
    }

    @Override
    public void insert(Recipe recipe) {
        Recipe recipeExists = recipeRepository.findByNameAndNutritionist(recipe.getName(),1);
        if (recipeExists!=null){
            throw new BusinessException("You already have a recipe with this name");
        }
        if (recipe.getUser().getId()!= Auth.getUser().getId()){
            throw new BusinessException("This recipe is not from the correct user ");
        }
        System.out.println(recipe);
        recipeRepository.insert(recipe);
    }

    @Override
    public void update(Recipe recipe) {
        if (recipe.getUser().getId()!= Auth.getUser().getId()){
            throw new BusinessException("This recipe is not from the correct user ");
        }
        recipeRepository.update(recipe);
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
