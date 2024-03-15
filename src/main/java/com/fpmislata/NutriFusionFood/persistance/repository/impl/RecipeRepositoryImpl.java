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
        return RecipeMapper.toRecipeList(recipeDao.findAllRecipe());
    }

    @Override
    public Recipe findByIdRecipe(Integer id) {
        return RecipeMapper.toRecipe(recipeDao.findByIdRecipe(id));
    }

    @Override
    public void delete(Integer id) {
        recipeDao.delete(id);
    }

    @Override
    public Recipe update() {
        return null;
    }

    public void insert(Recipe recipe) {
        recipeDao.insert(RecipeMapper.toRecipeEntity(recipe));
    }

    @Override
    public List<Recipe> findByCategory(Integer categoryId) {
        return RecipeMapper.toRecipeList(recipeDao.findByCategory(categoryId));

    }
}
