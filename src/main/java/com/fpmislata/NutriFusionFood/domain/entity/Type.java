package com.fpmislata.NutriFusionFood.domain.entity;

public class Type {
    private Integer id;
    private String name_es;
    private String name_en;

    //Constructor (all parameters)
    public Type(Integer id, String name_es, String name_en) {
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
}
