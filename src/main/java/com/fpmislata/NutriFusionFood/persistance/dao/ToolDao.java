package com.fpmislata.NutriFusionFood.persistance.dao;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;

import java.util.List;

public interface ToolDao {
    public List<ToolEntity> findAllTool();
    public ToolEntity findByIdTool(Integer id);
    public List<ToolEntity> findByRecipe(Integer recipeId);
    public void delete(Integer id);
}
