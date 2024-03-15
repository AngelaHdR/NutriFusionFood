package com.fpmislata.NutriFusionFood.persistance.dao.entity;

public class CategoryEntity {
    private Integer id;
    private String name;

    public CategoryEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
