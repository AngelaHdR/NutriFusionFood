package com.fpmislata.NutriFusionFood.persistance.dao.entity;

import java.util.Objects;

public class TypeEntity {
    private Integer id;
    private String name;

    //Constructor (all parameters)
    public TypeEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getters and setters
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeEntity that = (TypeEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
