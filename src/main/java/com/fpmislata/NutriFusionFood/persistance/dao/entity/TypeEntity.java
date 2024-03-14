package com.fpmislata.NutriFusionFood.persistance.dao.entity;

public class TypeEntity {
    private Integer id;
    private String name;

    public TypeEntity(Integer id, String name) {
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
