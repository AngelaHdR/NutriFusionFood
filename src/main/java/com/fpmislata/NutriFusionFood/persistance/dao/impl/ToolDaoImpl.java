package com.fpmislata.NutriFusionFood.persistance.dao.impl;

import com.fpmislata.NutriFusionFood.persistance.dao.ToolDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToolDaoImpl implements ToolDao {
    List<ToolEntity> toolEntityList = new ArrayList<>(Arrays.asList(
            new ToolEntity(1,"cuchillo"),
            new ToolEntity(2,"sarten"),
            new ToolEntity(3,"cuchara")
    ));
    @Override
    public List<ToolEntity> findAllTool() {
        return toolEntityList;
    }

    @Override
    public ToolEntity findByIdTool(Integer id) {
        for (ToolEntity toolEntity:toolEntityList){
            if (toolEntity.getId()==id){
                return toolEntity;
            }
        }
        return null;
    }

    @Override
    public void insert(ToolEntity toolEntity) {
        toolEntityList.add(toolEntity);
    }

    @Override
    public void delete(Integer id) {
        toolEntityList.remove(findByIdTool(id));
    }
}
