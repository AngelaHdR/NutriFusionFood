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

    public Recipe(Integer id, String description, String name, int time) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.time = time;
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
}
