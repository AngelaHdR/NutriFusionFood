package com.fpmislata.NutriFusionFood.persistance.dao.entity;


import java.util.Objects;

public class RecipeEntity {
    private Integer id;
    private String name;
    private String language;
    private String description;
    private String steps;
    private int time;
    private UserEntity user; //El usuario es siempre un nutricionista
    private CategoryEntity category;

    //Constructor

    public RecipeEntity(Integer id, String name,String language, String description, String steps, int time, UserEntity user, CategoryEntity category) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.language = language;
        this.time = time;
        this.steps = steps;
        this.user = user;
        this.category = category;
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

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
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

    public UserEntity getUser() {
        return this.user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CategoryEntity getCategory() {
        return category;
    }
    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getSteps() {
        return steps;
    }
    public void setSteps(String steps) {
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeEntity that = (RecipeEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
