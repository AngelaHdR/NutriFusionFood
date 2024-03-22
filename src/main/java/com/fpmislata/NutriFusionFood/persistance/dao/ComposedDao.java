package com.fpmislata.NutriFusionFood.persistance.dao;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.ComposedEntity;

import java.util.List;

public interface ComposedDao {
    public List<ComposedEntity> findAll();
    public List<ComposedEntity> findByRecipe(Integer recipeId);
}
