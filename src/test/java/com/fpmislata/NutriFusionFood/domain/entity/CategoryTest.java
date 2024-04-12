package com.fpmislata.NutriFusionFood.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CategoryTest {
    Category category;
    @Test
    void createAllParameters() {
        category = new Category(1, "postre", "dessert");
    }
    @Test
    void checkId() {
        category = new Category(1, "postre", "dessert");
        assertEquals(1, category.getId());
    }
    @Test
    void notModifyId() {
        category = new Category(1, "postre", "dessert");
        category.setId(2);
        assertEquals(1, category.getId());
    }
    @Test
    void checkNameEs() {
        category = new Category(1, "postre", "dessert");
        assertEquals("postre", category.getName_es());
    }
    @Test
    void notModifyNameEs() {
        category = new Category(1, "postre", "dessert");
        category.setName_es("dessert");
        assertEquals("postre", category.getName_es());
    }
    @Test
    void checkNameEn() {
        category = new Category(1, "postre", "dessert");
        assertEquals("dessert", category.getName_en());
    }
    @Test
    void notModifyNameEn() {
        category = new Category(1, "postre", "dessert");
        category.setName_en("postre");
        assertEquals("dessert", category.getName_en());
    }
}