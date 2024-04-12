package com.fpmislata.NutriFusionFood.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RecipeTest {
    Recipe recipe;

    @Test
    void voidConstructor() {
        recipe = new Recipe();
    }

    @Test
    void createAllParameters() {
        recipe = new Recipe(1, "tortilla", "spanish", "...", "...", 120);
    }

    @Test
    void checkId() {
        recipe = new Recipe(1, "tortilla", "spanish", "...", "...", 120);
        assertEquals(1, recipe.getId());
    }

    @Test
    void checkName() {
        recipe = new Recipe(1, "tortilla", "spanish", "...", "...", 120);
        assertEquals("tortilla", recipe.getName());
    }

    @Test
    void checkLanguage() {
        recipe = new Recipe(1, "tortilla", "spanish", "...", "...", 120);
        assertEquals("spanish", recipe.getLanguage());
    }

    @Test
    void checkDescription() {
        recipe = new Recipe(1, "tortilla", "spanish", "...", "...", 120);
        assertEquals("...", recipe.getDescription());
    }

    @Test
    void checkSteps() {
        recipe = new Recipe(1, "tortilla", "spanish", "...", "...", 120);
        assertEquals("...", recipe.getSteps());
    }

    @Test
    void checkTime() {
        recipe = new Recipe(1, "tortilla", "spanish", "...", "...", 120);
        assertEquals(120, recipe.getTime());
    }
}