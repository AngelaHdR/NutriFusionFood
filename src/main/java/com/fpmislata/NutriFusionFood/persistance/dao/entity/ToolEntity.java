package com.fpmislata.NutriFusionFood.persistance.dao.entity;

public class ToolEntity {
    private Integer id;
    private String name;

    public ToolEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public String gtName() {
        return this.name;
    }
}
