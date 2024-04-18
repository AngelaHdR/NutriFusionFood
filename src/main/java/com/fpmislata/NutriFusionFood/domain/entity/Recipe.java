package com.fpmislata.NutriFusionFood.domain.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe {
    private Integer id;
    private String description;
    private String name;
    private String language;
    private int time;
    private String steps;
    private List<Ingredient> ingredientList;
    private List<Tool> toolList;
    private User user;
    private Category category;
    private Map<String,Boolean> allergen;

    //Constructors (void and basic parameters)
    public Recipe() {
    }

    public Recipe(Integer id, String name, String language, String description, String steps, int time) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.language = language;
        this.time = time;
        this.steps = steps;
        this.allergen = new HashMap<>();
        allergen.put("gluten", false);
        allergen.put("lactose", false);
    }


    //Getters and setters
    public Integer getId() {
        return id;
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
    public void setLanguaje(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String,Boolean> getAllergen() {
        return allergen;
    }
    public void setAllergen(Map<String,Boolean> allergen) {
        this.allergen = allergen;
    }

    public String getSteps() {
        return steps;
    }
    public void setSteps(String steps) {
        this.steps = steps;
    }

    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }
    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<Tool> getToolList() {
        return toolList;
    }
    public void setToolList(List<Tool> toolList) {
        this.toolList = toolList;
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

}
