package com.fpmislata.NutriFusionFood.persistance.dao.entity;

public class RequireEntity {
    private Integer toolId;
    private Integer recipeId;

    public RequireEntity(Integer toolId, Integer recipeId) {
        this.toolId = toolId;
        this.recipeId = recipeId;
    }


    public Integer getToolId() {
        return toolId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }
}
