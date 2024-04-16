package com.fpmislata.NutriFusionFood.persistance.dao.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TypeEntityTest {
    TypeEntity typeEntity;

    @Test
    void createAllParameters() {
        typeEntity = new TypeEntity(1, "verdura", "vegetable");
    }

    @Test
    void checkId() {
        typeEntity = new TypeEntity(1, "verdura", "vegetable");
        assertEquals(1, typeEntity.getId());
    }

    @Test
    void checkNameEs() {
        typeEntity = new TypeEntity(1, "verdura", "vegetable");
        assertEquals("verdura", typeEntity.getName_es());
    }

    @Test
    void checkNameEn() {
        typeEntity = new TypeEntity(1, "verdura", "vegetable");
        assertEquals("vegetable", typeEntity.getName_en());
    }
}
