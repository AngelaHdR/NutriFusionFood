package com.fpmislata.NutriFusionFood.persistance.repository.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;

import java.util.ArrayList;
import java.util.List;

public class IngredientMapper {
    public static Ingredient toIngredient(IngredientEntity ingredientEntity){
        if (ingredientEntity == null){
            return null;
        }
        return new Ingredient(
                ingredientEntity.getId(),
                ingredientEntity.isGluten(),
                ingredientEntity.isLactose(),
                ingredientEntity.getName(),
                ingredientEntity.getStartSeason(),
                ingredientEntity.getEndSeason(),
                TypeMapper.toType(ingredientEntity.getType()));
    }

    public static IngredientEntity toIngredientEntity(Ingredient ingredient){
        if (ingredient == null){
            return null;
        }
        return new IngredientEntity(
                ingredient.getId(),
                ingredient.isGluten(),
                ingredient.isLactose(),
                ingredient.getName(),
                ingredient.getStartSeason(),
                ingredient.getEndSeason(),
                TypeMapper.toTypeEntity(ingredient.getType()));
    }
    public static List<Ingredient> toIngredientList(List<IngredientEntity> ingredientEntityList){
        List<Ingredient> ingredientList = new ArrayList<>();
        for (IngredientEntity ingredientEntity:ingredientEntityList){
            ingredientList.add(toIngredient(ingredientEntity));
        }
        return ingredientList;
    }
    public static List<IngredientEntity> toIngredientEntityList(List<Ingredient> ingredientList){
        List<IngredientEntity> ingredientEntityList = new ArrayList<>();
        for (Ingredient ingredient:ingredientList){
            ingredientEntityList.add(toIngredientEntity(ingredient));
        }
        return ingredientEntityList;
    }
}
