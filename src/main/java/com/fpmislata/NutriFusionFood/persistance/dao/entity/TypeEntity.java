package com.fpmislata.NutriFusionFood.persistance.dao.entity;

import java.util.Objects;

public class TypeEntity {
    private Integer id;
    private String name_es;
    private String name_en;

    //Constructor (all parameters)
    public TypeEntity(Integer id, String name_es, String name_en) {
        this.id = id;
        this.name_es = name_es;
        this.name_en = name_en;
    }

    //Getters and setters
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_es() {
        return this.name_es;
    }
    public void setName_es(String name_es) {
        this.name_es = name_es;
    }

    public String getName_en() {
        return name_en;
    }
    public void setName_en(String name_en) {
        this.name_en = name_en;
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
