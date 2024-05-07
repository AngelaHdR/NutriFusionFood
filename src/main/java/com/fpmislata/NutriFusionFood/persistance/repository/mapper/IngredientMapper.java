package com.fpmislata.NutriFusionFood.persistance.repository.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;

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
                ingredientEntity.getEndSeason());
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
                ingredient.getType().getId());
    }
}
