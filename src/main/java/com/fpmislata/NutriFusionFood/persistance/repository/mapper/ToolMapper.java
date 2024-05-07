package com.fpmislata.NutriFusionFood.persistance.repository.mapper;

import java.util.ArrayList;
import java.util.List;

import com.fpmislata.NutriFusionFood.domain.entity.Tool;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;

public class ToolMapper {
    public static Tool toTool(ToolEntity toolEntity){
        if (toolEntity == null){
            return null;
        }
        return new Tool(
                toolEntity.getId(),
                toolEntity.getName());
    }

    public static ToolEntity toToolEntity(Tool tool){
        if (tool == null){
            return null;
        }
        return new ToolEntity(
                tool.getId(),
                tool.getName());
    }
    public static List<Tool> toToolList(List<ToolEntity> toolEntityList){
        List<Tool> toolList = new ArrayList<>();
        for(ToolEntity toolEntity:toolEntityList){
            toolList.add(toTool(toolEntity));
        }
        return toolList;
    }
}
