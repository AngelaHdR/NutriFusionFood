package com.fpmislata.NutriFusionFood.domain.entity;

import java.util.Objects;

public class Ingredient {
    private Integer id;
    private Boolean gluten;
    private Boolean lactose;
    private String name;
    private Integer startSeason;
    private Integer endSeason;
    private Type type;

    //Constructors (void, basic parameters and all parameters)
    public Ingredient() {
    }
    public Ingredient(Integer id) {
        this.id = id;
    }
    public Ingredient(Integer id, Boolean gluten, Boolean lactose, String name, Integer startSeason, Integer endSeason) {
        this.id = id;
        this.gluten = gluten;
        this.lactose = lactose;
        this.name = name;
        this.startSeason = startSeason;
        this.endSeason = endSeason;
    }
    public Ingredient(Integer id, Boolean gluten, Boolean lactose, String name, Integer startSeason, Integer endSeason, Type type) {
        this.id = id;
        this.gluten = gluten;
        this.lactose = lactose;
        this.name = name;
        this.startSeason = startSeason;
        this.endSeason = endSeason;
        this.type = type;
    }

    //Getters and setters
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean isGluten() {
        return this.gluten;
    }
    public void setGluten(Boolean gluten) {
        this.gluten = gluten;
    }

    public Boolean isLactose() {
        return this.lactose;
    }
    public void setLactose(Boolean lactose) {
        this.lactose = lactose;
    }

    public String getName() {
        return name;
    }
    public void setName_es(String name) {
        this.name = name;
    }

    public Integer getStartSeason() {
        return startSeason;
    }
    public void setStartSeason(Integer startSeason) {
        this.startSeason = startSeason;
    }

    public Integer getEndSeason() {
        return endSeason;
    }
    public void setEndSeason(Integer endSeason) {
        this.endSeason = endSeason;
    }

    public Type getType() {
        return this.type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}