package com.fpmislata.NutriFusionFood.persistance.repository.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;

import java.util.ArrayList;
import java.util.List;

public class RecipeMapper {
    public static Recipe toRecipe(RecipeEntity recipeEntity){
        if (recipeEntity == null){
            return null;
        }
        return new Recipe(recipeEntity.getId(),recipeEntity.getName(), recipeEntity.getLanguage(),recipeEntity.getDescription(), recipeEntity.getSteps(), recipeEntity.getTime());
    }
    public static RecipeEntity toRecipeEntity(Recipe recipe){
        if (recipe == null){
            return null;
        }
        return new RecipeEntity(recipe.getId(),recipe.getName(), recipe.getLanguage(), recipe.getDescription(), recipe.getSteps(), recipe.getTime(),recipe.getUser().getId(),recipe.getCategory().getId());
    }
    public static List<Recipe> toRecipeList(List<RecipeEntity> recipeEntityList){
        List<Recipe> recipeList = new ArrayList<>();
        for (RecipeEntity recipeEntity:recipeEntityList){
            recipeList.add(toRecipe(recipeEntity));
        }
        return recipeList;
    }
}
