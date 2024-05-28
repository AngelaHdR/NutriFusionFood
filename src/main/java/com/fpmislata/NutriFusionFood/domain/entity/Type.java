package com.fpmislata.NutriFusionFood.domain.entity;

public class Type {
    private Integer id;
    private String name;

    //Constructor (all parameters)
    public Type(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getters and setters
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        /* Funcionalidad no Implementada para Clientes */
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        /* Funcionalidad no Implementada para Clientes */
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
