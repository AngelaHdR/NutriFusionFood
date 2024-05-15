package com.fpmislata.NutriFusionFood.persistance.repository.impl;

import java.util.List;

import com.fpmislata.NutriFusionFood.domain.entity.Tool;
import com.fpmislata.NutriFusionFood.persistance.dao.ToolDao;
import com.fpmislata.NutriFusionFood.persistance.repository.ToolRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.ToolMapper;

public class ToolRepositoryImpl implements ToolRepository {
    private ToolDao toolDao;
    public ToolRepositoryImpl(ToolDao toolDao){
        this.toolDao = toolDao;
    }

    @Override
    public List<Tool> findAllTool() {
        return ToolMapper.toToolList(toolDao.findAllTool());
    }

    @Override
    public Tool findByIdTool(Integer id) {
        return ToolMapper.toTool(toolDao.findByIdTool(id));
    }
    
}
