package com.fpmislata.NutriFusionFood.persistance.repository;

import java.util.List;

import com.fpmislata.NutriFusionFood.domain.entity.Tool;

public interface ToolRepository {
    public List<Tool> findAllTool();
    public Tool findByIdTool(Integer id);
}
