package com.fpmislata.NutriFusionFood.persistance.dao.impl;

import com.fpmislata.NutriFusionFood.persistance.dao.RequireDao;
import com.fpmislata.NutriFusionFood.persistance.dao.ToolDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RequireEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToolDaoImpl implements ToolDao {
    private RequireDao requireDao;

    List<ToolEntity> toolEntityList = new ArrayList<>(Arrays.asList(
            new ToolEntity(1,"cuchara"),
            new ToolEntity(2,"bol"),
            new ToolEntity(3,"sarten"),
            new ToolEntity(4,"olla"),
            new ToolEntity(5,"vaso medidor"),
            new ToolEntity(6,"batidora")
    ));

    public ToolDaoImpl() {
        this.requireDao = new RequireDaoImpl();
    }

    @Override
    public List<ToolEntity> findAllTool() {
        return toolEntityList;
    }

    @Override
    public ToolEntity findByIdTool(Integer id) {
        for (ToolEntity toolEntity:toolEntityList){
            if (toolEntity.getId().equals(id)){
                return toolEntity;
            }
        }
        return null;
    }

    @Override
    public List<ToolEntity> findByRecipe(Integer recipeId){
        List<RequireEntity> requireList = requireDao.findByRecipe(recipeId);
        List<ToolEntity> requireToolList = new ArrayList<>();
        for (RequireEntity requireEntity : requireList){
            requireToolList.add(findByIdTool(requireEntity.getToolId()));
        }
        return requireToolList;
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
