package com.fpmislata.NutriFusionFood.persistance.repository.impl;

import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.repository.RecipeRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.RecipeMapper;

import java.util.List;

public class RecipeRepositoryImpl implements RecipeRepository {
    private RecipeDao recipeDao;

    public RecipeRepositoryImpl(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }


    @Override
    public List<Recipe> findAllRecipe() {
        List<Recipe> recipes = RecipeMapper.toRecipeList(recipeDao.findAllRecipe());
        return recipes;
    }

    @Override
    public Recipe findByIdRecipe(Integer id) {
        Recipe recipe= RecipeMapper.toRecipe(recipeDao.findByIdRecipe(id));
        return recipe ;
    }

    @Override
    public void delete(Integer id) {
        recipeDao.delete(id);
    }


    public void insert(Recipe recipe) {
        recipeDao.insert(RecipeMapper.toRecipeEntity(recipe));
    }

    @Override
    public List<Recipe> findByCategory(Integer categoryId) {
        return RecipeMapper.toRecipeList(recipeDao.findByCategory(categoryId));

    }
}
