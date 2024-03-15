package com.fpmislata.NutriFusionFood.persistance.dao.entity;

public class RecipeEntity {
    private Integer id;
    private String description;
    private String name;
    private int time;
    private Integer userId; //El usuario es siempre un nutricionista
    private Integer categoryId;

    public RecipeEntity(Integer id, String name, String description, int time, Integer userId, Integer categoryId) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.time = time;
        this.userId = userId;
        this.categoryId = categoryId;
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

    public Integer getCategoryId() {
        return categoryId;
    }
}
