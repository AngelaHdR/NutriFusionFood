package com.fpmislata.NutriFusionFood.persistance.dao.entity;

import java.time.LocalDate;

public class IngredientEntity {
    private Integer id;
    private Boolean gluten;
    private Boolean lactose;
    private String name;
    private LocalDate season;
    private Integer typeId;

    public IngredientEntity(Integer id, Boolean gluten, Boolean lactose, String name, LocalDate season, Integer typeId) {
        this.id = id;
        this.gluten = gluten;
        this.lactose = lactose;
        this.name = name;
        this.season = season;
        this.typeId = typeId;
    }

    public Integer getId() {
        return this.id;
    }

    public Boolean getGluten() {
        return this.gluten;
    }

    public Boolean getLactose() {
        return this.lactose;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getSeason() {
        return this.season;
    }

    public Integer getTypeId() {
        return this.typeId;
    }
}
