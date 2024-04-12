package com.fpmislata.NutriFusionFood.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RecipeEntityTest {
    RecipeEntity recipeEntity;

    @Test
    void createAllParameters() {
        recipeEntity = new RecipeEntity(1, "tortilla", "spanish", "...", "...", 120, 1, 1);
    }

    @Test
    void checkId() {
        recipeEntity = new RecipeEntity(1, "tortilla", "spanish", "...", "...", 120, 1, 1);
        assertEquals(1, recipeEntity.getId());
    }

    @Test
    void checkName() {
        recipeEntity = new RecipeEntity(1, "tortilla", "spanish", "...", "...", 120, 1, 1);
        assertEquals("tortilla", recipeEntity.getName());
    }

    @Test
    void checkLanguage() {
        recipeEntity = new RecipeEntity(1, "tortilla", "spanish", "...", "...", 120, 1, 1);
        assertEquals("spanish", recipeEntity.getLanguage());
    }

    @Test
    void checkDescription() {
        recipeEntity = new RecipeEntity(1, "tortilla", "spanish", "...", "...", 120, 1, 1);
        assertEquals("...", recipeEntity.getDescription());
    }

    @Test
    void checkSteps() {
        recipeEntity = new RecipeEntity(1, "tortilla", "spanish", "...", "...", 120, 1, 1);
        assertEquals("...", recipeEntity.getSteps());
    }

    @Test
    void checkTime() {
        recipeEntity = new RecipeEntity(1, "tortilla", "spanish", "...", "...", 120, 1, 1);
        assertEquals(120, recipeEntity.getTime());
    }

    @Test
    void checkUserId() {
        recipeEntity = new RecipeEntity(1, "tortilla", "spanish", "...", "...", 120, 1, 1);
        assertEquals(1, recipeEntity.getUserId());
    }

    @Test
    void checkCategoryId() {
        recipeEntity = new RecipeEntity(1, "tortilla", "spanish", "...", "...", 120, 1, 1);
        assertEquals(1, recipeEntity.getCategoryId());
    }
}
