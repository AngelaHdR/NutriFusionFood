package com.fpmislata.NutriFusionFood.persistance.dao.impl.memory;

import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeDaoMemory implements RecipeDao {
    List<RecipeEntity> recipeEntityList = new ArrayList<>(Arrays.asList(
            new RecipeEntity(1,"Tortilla patata","es", "x","Paso 1...", 30,new UserEntity(),new CategoryEntity()),
            new RecipeEntity(2,"Salmorejo","es","x", "Paso 1...", 60,new UserEntity(),new CategoryEntity()),
            new RecipeEntity(3,"Ramen", "es","x","Paso 1...", 240,new UserEntity(),new CategoryEntity()),
            new RecipeEntity(4,"Torrijas", "es","x","Paso 1...", 45,new UserEntity(),new CategoryEntity()),
            new RecipeEntity(5,"Smoothie", "es","x","Paso 1...", 15,new UserEntity(),new CategoryEntity())
    ));

    @Override
    public List<RecipeEntity> findAllRecipe() {
        return recipeEntityList;
    }

    @Override
    public RecipeEntity findByIdRecipe(Integer id) {
        for (RecipeEntity recipeEntity:recipeEntityList){
            if (recipeEntity.getId().equals(id)){
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
    public List<RecipeEntity> findByCategory(Integer categoryId) {
        List<RecipeEntity> recipeCategoryList = new ArrayList<>();
        for (RecipeEntity recipeEntity:recipeEntityList){
            if (recipeEntity.getCategory().equals(categoryId)){
                recipeCategoryList.add(recipeEntity);
            }
        }
        return recipeCategoryList;
    }
    @Override
    public List<RecipeEntity> findByNutritionist(Integer nutritionistId) {
        List<RecipeEntity> nutritionistList = new ArrayList<>();
        for (RecipeEntity recipeEntity:recipeEntityList){
            if (recipeEntity.getUser().equals(nutritionistId)){
                nutritionistList.add(recipeEntity);
            }
        }
        return nutritionistList;
    }

    @Override
    public RecipeEntity findByNameAndNutritionist(String name, int userId) {
        return null;
    }
}
