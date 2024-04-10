package com.fpmislata.NutriFusionFood.persistance.dao.entity;

public class RecipeEntity {
    private Integer id;
    private String name;
    private String languaje;
    private String description;
    private String steps;
    private int time;
    private Integer userId; //El usuario es siempre un nutricionista
    private Integer categoryId;

    //Constructor

    public RecipeEntity(Integer id, String name,String languaje, String description, String steps, int time, Integer userId, Integer categoryId) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.languaje = languaje;
        this.time = time;
        this.steps = steps;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    //Getters and setters
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLanguaje() {
        return languaje;
    }
    public void setLanguaje(String languaje) {
        this.languaje = languaje;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return this.time;
    }
    public void setTime(int time) {
        this.time = time;
    }

    public Integer getUserId() {
        return this.userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getSteps() {
        return steps;
    }
    public void setSteps(String steps) {
        this.steps = steps;
    }

}
