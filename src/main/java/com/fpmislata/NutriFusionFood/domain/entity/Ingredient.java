package com.fpmislata.NutriFusionFood.domain.entity;

import java.time.LocalDate;

public class Ingredient {
    private Integer id;
    private Boolean gluten;
    private Boolean lactose;
    private String name;
    private LocalDate season;
    private Type type;

    public Ingredient(Integer id, Boolean gluten, Boolean lactose, String name, LocalDate season) {
        this.id = id;
        this.gluten = gluten;
        this.lactose = lactose;
        this.name = name;
        this.season = season;
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

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}