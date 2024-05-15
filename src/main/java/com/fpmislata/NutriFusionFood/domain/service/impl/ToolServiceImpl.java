package com.fpmislata.NutriFusionFood.domain.service.impl;

import java.util.List;

import com.fpmislata.NutriFusionFood.domain.entity.Tool;
import com.fpmislata.NutriFusionFood.domain.service.ToolService;
import com.fpmislata.NutriFusionFood.persistance.repository.ToolRepository;

public class ToolServiceImpl implements ToolService{
    private ToolRepository toolRepository;

    public ToolServiceImpl(ToolRepository toolRepository){
        this.toolRepository = toolRepository;
    }

    @Override
    public List<Tool> findAllTool() {
        return this.toolRepository.findAllTool();
    }

    @Override
    public Tool findByIdTool(Integer id) {
        Tool tool = this.toolRepository.findByIdTool(id);
        return tool;
    }
}
