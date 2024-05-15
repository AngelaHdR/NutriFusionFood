package com.fpmislata.NutriFusionFood.domain.service;

import java.util.List;

import com.fpmislata.NutriFusionFood.domain.entity.Tool;

public interface ToolService {
    public List<Tool> findAllTool();
    public Tool findByIdTool(Integer id);
}
