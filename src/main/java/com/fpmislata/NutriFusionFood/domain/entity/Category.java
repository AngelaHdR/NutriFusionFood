package com.fpmislata.NutriFusionFood.domain.entity;

public class Category {
    private Integer id;
    private String name;

    //Constructor (void, all parameters)
    public Category() {
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getters and setters
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        //Funcionalidad no implementada para clientes
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        //Funcionalidad no implementada para clientes
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
