package com.fpmislata.NutriFusionFood.persistance.dao.entity;

public class RecipeEntity {
    private Integer id;
    private String description;
    private String name;
    private int time;
    private Integer userId;

    public RecipeEntity(Integer id, String description, String name, int time, Integer userId) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.time = time;
        this.userId = userId;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public int getTime() {
        return this.time;
    }

    public Integer getUserId() {
        return this.userId;
    }
}
