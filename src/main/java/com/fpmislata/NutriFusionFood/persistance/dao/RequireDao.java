package com.fpmislata.NutriFusionFood.persistance.dao;

import com.fpmislata.NutriFusionFood.domain.entity.Tool;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RequireEntity;

import java.util.List;

public interface RequireDao {
    public List<RequireEntity> findAll();
    public List<RequireEntity> findByRecipe(Integer recipeId);
}
