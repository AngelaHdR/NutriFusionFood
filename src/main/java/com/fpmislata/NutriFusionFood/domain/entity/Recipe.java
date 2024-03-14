package com.fpmislata.NutriFusionFood.domain.entity;

public class Recipe {
    private Integer id;
    private String description;
    private String name;
    private int time;
    private Ingredient ingredient;
    private Tool tool;

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

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Tool getTool() {
        return this.tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }
}
