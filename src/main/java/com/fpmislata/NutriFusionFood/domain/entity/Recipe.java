package com.fpmislata.NutriFusionFood.domain.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Recipe {
    private Integer id;
    private String description;
    private String name;
    private String language;
    private int time;
    //private String stepsDescription;
    private List<Step> steps;
    private List<Ingredient> ingredientList;
    private List<Tool> toolList;
    private User user;
    private Category category;
    private Map<String,Boolean> allergen;

    //Constructors (void, basic parameters, with user and category and all parameters)
    public Recipe() {
        this.allergen = new HashMap<>();
        allergen.put("gluten", false);
        allergen.put("lactose", false);
    }

    public Recipe(String name, String language, String description, int time) {
        this.description = description;
        this.name = name;
        this.language = language;
        this.time = time;
        this.allergen = new HashMap<>();
        allergen.put("gluten", false);
        allergen.put("lactose", false);
    }

    public Recipe(Integer id, String name, String language, String description, List<Step> steps,
                  int time, List<Ingredient> ingredientList, List<Tool> toolList, User user,
                  Category category, Map<String, Boolean> allergen) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.language = language;
        this.time = time;
        this.steps = steps;
        this.ingredientList = ingredientList;
        this.toolList = toolList;
        this.user = user;
        this.category = category;
        this.allergen = allergen;
        allergen.put("gluten", false);
        allergen.put("lactose", false);
    }

    public Recipe(Integer id, String name, String language, String description, List<Step> steps,
                  int time, User user, Category category) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.language = language;
        this.time = time;
        this.steps = steps;
        this.user = user;
        this.category = category;
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
    public void setLanguage(String language) {
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

    public List<Step> getSteps() {
        return steps;
    }
    public void setSteps(List<Step> steps) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", time=" + time +
                ", steps='" + steps + '\'' +
                ", ingredientList=" + ingredientList +
                ", toolList=" + toolList +
                ", user=" + user +
                ", category=" + category +
                ", allergen=" + allergen +
                '}';
    }
}
