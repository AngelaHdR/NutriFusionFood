package com.fpmislata.NutriFusionFood.domain.entity;

import java.util.List;

public class Recipe {
    private Integer id;
    private String description;
    private String name;
    private int time;
    private List<Ingredient> ingredientlist;
    private List<Tool> toollist;
    private User user;
    private Category category;
    private List<Boolean> allergen;

    public Recipe() {
    }

    public Recipe(Integer id, String description, String name, int time) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<Ingredient> getIngredientlist() {
        return ingredientlist;
    }

    public void setIngredientlist(List<Ingredient> ingredientlist) {
        this.ingredientlist = ingredientlist;
    }

    public List<Tool> getToollist() {
        return toollist;
    }

    public void setToollist(List<Tool> toollist) {
        this.toollist = toollist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Boolean> getAllergen() {
        return allergen;
    }

    public void setAllergen(List<Boolean> allergen) {
        this.allergen = allergen;
    }
}
