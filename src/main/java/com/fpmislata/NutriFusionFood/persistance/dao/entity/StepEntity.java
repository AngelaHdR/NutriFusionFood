package com.fpmislata.NutriFusionFood.persistance.dao.entity;

import com.fpmislata.NutriFusionFood.domain.entity.Step;

import java.util.Objects;

public class StepEntity {
    private Integer id;
    private String description;

    public StepEntity(Integer id, String description) {
        this.id = id;
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StepEntity step = (StepEntity) o;
        return Objects.equals(id, step.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
