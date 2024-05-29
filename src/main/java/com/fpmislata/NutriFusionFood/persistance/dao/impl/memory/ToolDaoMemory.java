package com.fpmislata.NutriFusionFood.persistance.dao.impl.memory;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.RequireDao;
import com.fpmislata.NutriFusionFood.persistance.dao.ToolDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RequireEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToolDaoMemory implements ToolDao {
    private RequireDao requireDao;

    List<ToolEntity> toolEntityList_es = new ArrayList<>(Arrays.asList(
            new ToolEntity(1,"cuchara"),
            new ToolEntity(2,"bol"),
            new ToolEntity(3,"sarten"),
            new ToolEntity(4,"olla"),
            new ToolEntity(5,"vaso medidor"),
            new ToolEntity(6,"batidora")
    ));
    List<ToolEntity> toolEntityList_en = new ArrayList<>(Arrays.asList(
            new ToolEntity(1,"spoon"),
            new ToolEntity(2,"bowl"),
            new ToolEntity(3,"frying pan"),
            new ToolEntity(4,"pot"),
            new ToolEntity(5,"measuring cup"),
            new ToolEntity(6,"blender")
    ));

    private String lang = AppPropertiesReader.getInstance().getProperty("lang");

    public ToolDaoMemory() {
        this.requireDao = new RequireDaoMemory();
    }

    @Override
    public List<ToolEntity> findAllTool() {
        List<ToolEntity> toolEntityList=null;
        if (lang.equals("es")){
            toolEntityList=toolEntityList_es;
        } else if (lang.equals("en")) {
            toolEntityList=toolEntityList_en;
        }
        return toolEntityList;
    }

    @Override
    public ToolEntity findByIdTool(Integer id) {
        List<ToolEntity> toolEntityList=null;
        if (lang.equals("es")){
            toolEntityList=toolEntityList_es;
        } else if (lang.equals("en")) {
            toolEntityList=toolEntityList_en;
        }
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
    public void delete(Integer id) {
        if (lang.equals("es")){
            toolEntityList_es.remove(findByIdTool(id));
        } else if (lang.equals("en")) {
            toolEntityList_en.remove(findByIdTool(id));
        }
    }
}
