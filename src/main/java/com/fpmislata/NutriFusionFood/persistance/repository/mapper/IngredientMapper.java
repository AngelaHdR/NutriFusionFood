package com.fpmislata.NutriFusionFood.persistance.repository.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;

public class IngredientMapper {
    public static Ingredient toIngredient(IngredientEntity ingredientEntity){
        return new Ingredient(ingredientEntity.getId(), ingredientEntity.getGluten(),ingredientEntity.getLactose(),ingredientEntity.getName(),ingredientEntity.getStartseason(),ingredientEntity.getEndseason());
    }

    public static IngredientEntity toIngredientEntity(Ingredient ingredient){
        return new IngredientEntity(ingredient.getId(),ingredient.getGluten(),ingredient.getLactose(),ingredient.getName(),ingredient.getStartseason(),ingredient.getEndseason());
    }
}
