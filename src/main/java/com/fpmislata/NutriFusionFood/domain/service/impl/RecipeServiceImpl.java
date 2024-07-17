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

    @Override
    public List<Recipe> findByAllergen(String allergen) {
        if (allergen.equals("lactose")){
            return this.recipeRepository.findByNoLactose();
        } else if (allergen.equals("gluten")) {
            return this.recipeRepository.findByNoGluten();
        }else {
            throw new BusinessException(("This allergen doesn't exist"));
        }
    }

    @Override
    public List<Recipe> findByTime(Integer timeMin, Integer timeMax) {
        return this.recipeRepository.findByTime(timeMin,timeMax);
    }
    public List<Integer> findMaxMinTime(){
        return this.recipeRepository.findMaxMinTime();
    }

    @Override
    public void modifyFavorites(Integer recipeId, Boolean status, Integer userId) {
        Recipe recipe = findByIdRecipe(recipeId);
        if (recipe.getUser().getId()== Auth.getUser().getId()){
            throw new BusinessException("This recipe is from the current user ");
        }
        if (status){
            this.recipeRepository.removeFavorites(recipe,userId);
        }
        this.recipeRepository.addFavorites(recipe,userId);
    }
}
