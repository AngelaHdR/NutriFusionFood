package com.fpmislata.NutriFusionFood.persistance.dao.entity;

public class ComposedEntity {
    private Integer ingredientId;
    private Integer recipeId;

    public ComposedEntity(Integer ingredientId, Integer recipeId) {
        this.ingredientId = ingredientId;
        this.recipeId = recipeId;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }
}
