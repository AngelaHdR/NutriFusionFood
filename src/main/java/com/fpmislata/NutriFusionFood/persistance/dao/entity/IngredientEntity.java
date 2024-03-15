package com.fpmislata.NutriFusionFood.persistance.dao.entity;

public class IngredientEntity {
    private Integer id;
    private Boolean gluten;
    private Boolean lactose;
    private String name;
    private Integer startseason;
    private Integer endseason;
    private Integer typeId;

    public IngredientEntity(Integer id, Boolean gluten, Boolean lactose, String name, Integer startseason, Integer endseason, Integer typeId) {
        this.id = id;
        this.gluten = gluten;
        this.lactose = lactose;
        this.name = name;
        this.startseason = startseason;
        this.endseason = endseason;
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

    public Integer getTypeId() {
        return this.typeId;
    }

    public Integer getStartseason() {
        return startseason;
    }

    public Integer getEndseason() {
        return endseason;
    }
}
