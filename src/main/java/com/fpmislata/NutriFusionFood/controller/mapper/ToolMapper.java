package com.fpmislata.NutriFusionFood.controller.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Tool;

import java.util.ArrayList;
import java.util.List;

public class ToolMapper {

    public static Tool toTool(Integer toolId) {
        return new Tool(toolId, null);
    }

    public static List<Tool> toToolList(List<Integer> toolIdList) {
        List<Tool> toolList = new ArrayList<>();
        for (Integer toolId: toolIdList) {
            toolList.add(toTool(toolId));
        }
        return toolList;
    }
}
