package com.fpmislata.NutriFusionFood.persistance.repository.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Category;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class RecipeMapper {
    public static Recipe toRecipe(RecipeEntity recipeEntity){
        if (recipeEntity == null){
            return null;
        }
        return new Recipe(
                recipeEntity.getId(),
                recipeEntity.getName(),
                recipeEntity.getLanguage(),
                recipeEntity.getDescription(),
                recipeEntity.getSteps(),
                recipeEntity.getTime(),
                UserMapper.toUser(recipeEntity.getUser()),
                CategoryMapper.toCategory(recipeEntity.getCategory())
                );
    }
    public static RecipeEntity toRecipeEntity(Recipe recipe){
        if (recipe == null){
            return null;
        }
        User user = recipe.getUser();
        Category category = recipe.getCategory();
        return new RecipeEntity(
                recipe.getId(),
                recipe.getName(),
                recipe.getLanguage(),
                recipe.getDescription(),
                recipe.getSteps(),
                recipe.getTime(),
                new UserEntity(
                        user.getId(),
                        user.getName(),
                        user.getSurname1(),
                        user.getSurname2(),
                        user.getBirthDate(),
                        user.isNutritionist(),
                        user.getPassword(),
                        user.getEmail(),
                        user.getUsername()
                ),
                new CategoryEntity(
                        category.getId(),
                        category.getName()
                ));
    }
    public static List<Recipe> toRecipeList(List<RecipeEntity> recipeEntityList){
        List<Recipe> recipeList = new ArrayList<>();
        for (RecipeEntity recipeEntity:recipeEntityList){
            recipeList.add(toRecipe(recipeEntity));
        }
        return recipeList;
    }
}
