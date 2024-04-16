package com.fpmislata.NutriFusionFood.persistance.repository.impl;

import com.fpmislata.NutriFusionFood.common.UserIoC;
import com.fpmislata.NutriFusionFood.domain.entity.Category;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.persistance.dao.CategoryDao;
import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.UserDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.CategoryDaoImpl;
import com.fpmislata.NutriFusionFood.persistance.repository.RecipeRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.CategoryMapper;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.RecipeMapper;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.UserMapper;

import java.util.List;

public class RecipeRepositoryImpl implements RecipeRepository {
    private RecipeDao recipeDao;
    private UserDao userDao;
    private CategoryDao categoryDao;

    public RecipeRepositoryImpl(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
        this.userDao = UserIoC.getUserDao();
        this.categoryDao = new CategoryDaoImpl();
    }


    @Override
    public List<Recipe> findAllRecipe() {
        List<Recipe> recipes = RecipeMapper.toRecipeList(recipeDao.findAllRecipe());
        return recipes;
    }

    @Override
    public Recipe findByIdRecipe(Integer id) {
        RecipeEntity recipeEntity = recipeDao.findByIdRecipe(id);
        Recipe recipe = RecipeMapper.toRecipe(recipeEntity);

        //Añadir usuario
        int idUser = recipeEntity.getUserId();
        User user = UserMapper.toUser(userDao.findByIdNutritionist(idUser));
        recipe.setUser(user);

        //Añadir categoria
        int idCategory = recipeEntity.getCategoryId();
        Category category = CategoryMapper.toCategory(categoryDao.findByIdCategory(idCategory));
        recipe.setCategory(category);

        //Crear las tablas de enlace tool-recipe-ingredient y añadir las listas
        return recipe;
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
