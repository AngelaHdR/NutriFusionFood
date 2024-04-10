package com.fpmislata.NutriFusionFood.persistance.repository.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Tool;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;

public class ToolMapper {
    public static Tool toTool(ToolEntity toolEntity){
        return new Tool(toolEntity.getId(),toolEntity.getName_es(), toolEntity.getName_en());
    }

    public static ToolEntity toToolEntity(Tool tool){
        return new ToolEntity(tool.getId(),tool.getName_es(), tool.getName_en());
    }
}
