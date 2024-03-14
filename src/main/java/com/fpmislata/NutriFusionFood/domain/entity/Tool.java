package com.fpmislata.NutriFusionFood.domain.entity;

public class Tool {
    private Integer id;
    private String name;

    public Tool(Integer id, String name) {
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
