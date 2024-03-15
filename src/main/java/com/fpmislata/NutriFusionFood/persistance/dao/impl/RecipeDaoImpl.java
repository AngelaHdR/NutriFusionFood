package com.fpmislata.NutriFusionFood.persistance.dao.impl;

import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeDaoImpl implements RecipeDao {
    List<RecipeEntity> recipeEntityList = new ArrayList<>(Arrays.asList(
            new RecipeEntity(1,"Tortilla patata", "Paso 1...", 115,1,1)
    ));

    @Override
    public List<RecipeEntity> findAllRecipe() {
        return recipeEntityList;
    }

    @Override
    public RecipeEntity findByIdRecipe(Integer id) {
        for (RecipeEntity recipeEntity:recipeEntityList){
            if (recipeEntity.getId()==id){
                return recipeEntity;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        recipeEntityList.remove(findByIdRecipe(id));
    }

    @Override
    public void insert(RecipeEntity recipeEntity) {
        recipeEntityList.add(recipeEntity);
    }

    @Override
    public RecipeEntity update() {
        return null;
    }

    @Override
    public List<RecipeEntity> findByCategory(Integer categoryId) {
        List<RecipeEntity> recipeCategoryList = new ArrayList<>();
        for (RecipeEntity recipeEntity:recipeEntityList){
            if (recipeEntity.getCategoryId()==categoryId){
                recipeCategoryList.add(recipeEntity);
            }
        }
        return recipeCategoryList;
    }
    @Override
    public List<RecipeEntity> findByNutritionist(Integer nutritionistId) {
        List<RecipeEntity> nutritionistList = new ArrayList<>();
        for (RecipeEntity recipeEntity:recipeEntityList){
            if (recipeEntity.getUserId()==nutritionistId){
                nutritionistList.add(recipeEntity);
            }
        }
        return nutritionistList;
    }
}
