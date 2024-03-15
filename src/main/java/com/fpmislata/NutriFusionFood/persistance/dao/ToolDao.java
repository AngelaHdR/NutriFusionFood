package com.fpmislata.NutriFusionFood.persistance.dao;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;

import java.util.List;

public interface ToolDao {
    public List<ToolEntity> findAllTool();
    public ToolEntity findByIdTool(Integer id);
    public void insert(ToolEntity toolEntity);
    public void delete(Integer id);
}
