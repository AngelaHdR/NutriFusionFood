package com.fpmislata.NutriFusionFood.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CategoryEntityTest {
    CategoryEntity categoryEntity;
    @Test
    void createAllParameters() {
        categoryEntity = new CategoryEntity(1, "postre", "dessert");
    }
    @Test
    void checkId() {
        categoryEntity = new CategoryEntity(1, "postre", "dessert");
        assertEquals(1, categoryEntity.getId());
    }
    @Test
    void notModifyId() {
        categoryEntity = new CategoryEntity(1, "postre", "dessert");
        categoryEntity.setId(2);
        assertEquals(1, categoryEntity.getId());
    }
    @Test
    void checkNameEs() {
        categoryEntity = new CategoryEntity(1, "postre", "dessert");
        assertEquals("postre", categoryEntity.getName_es());
    }
    @Test
    void notModifyNameEs() {
        categoryEntity = new CategoryEntity(1, "postre", "dessert");
        categoryEntity.setName_es("dessert");
        assertEquals("postre", categoryEntity.getName_es());
    }
    @Test
    void checkNameEn() {
        categoryEntity = new CategoryEntity(1, "postre", "dessert");
        assertEquals("dessert", categoryEntity.getName_en());
    }
    @Test
    void notModifyNameEn() {
        categoryEntity = new CategoryEntity(1, "postre", "dessert");
        categoryEntity.setName_en("postre");
        assertEquals("dessert", categoryEntity.getName_en());
    }
}