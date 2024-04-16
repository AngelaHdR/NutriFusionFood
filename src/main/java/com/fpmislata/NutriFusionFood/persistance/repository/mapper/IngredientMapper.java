package com.fpmislata.NutriFusionFood.persistance.repository.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;

public class IngredientMapper {
    public static Ingredient toIngredient(IngredientEntity ingredientEntity){
        return new Ingredient(ingredientEntity.getId(), ingredientEntity.isGluten(),ingredientEntity.isLactose(),ingredientEntity.getName_es(), ingredientEntity.getName_en(), ingredientEntity.getStartSeason(),ingredientEntity.getEndSeason());
    }

    public static IngredientEntity toIngredientEntity(Ingredient ingredient){
        return new IngredientEntity(ingredient.getId(),ingredient.isGluten(),ingredient.isLactose(),ingredient.getName_es(), ingredient.getName_en(), ingredient.getStartSeason(),ingredient.getEndSeason(),ingredient.getType().getId());
    }
}
