package com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.memory;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.ComposedDao;
import com.fpmislata.NutriFusionFood.persistance.dao.IngredientDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ComposedEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IngredientDaoMemory implements IngredientDao {
    private ComposedDao composedDao;

    List<IngredientEntity> ingredientEntityList_es = new ArrayList<>(Arrays.asList(
            new IngredientEntity(1,true,false,"pan",10,12, new TypeEntity()),
            new IngredientEntity(2,false,false,"pollo",10,12, new TypeEntity()),
            new IngredientEntity(3,false,false,"tomate",10,12, new TypeEntity()),
            new IngredientEntity(4,false,false,"puerro",10,12, new TypeEntity()),
            new IngredientEntity(5,false,true,"helado",10,12, new TypeEntity())
    ));
    List<IngredientEntity> ingredientEntityList_en = new ArrayList<>(Arrays.asList(
            new IngredientEntity(1,true,false,"bread",10,12, new TypeEntity()),
            new IngredientEntity(2,false,false,"chicken",10,12, new TypeEntity()),
            new IngredientEntity(3,false,false,"tomato",10,12, new TypeEntity()),
            new IngredientEntity(4,false,false,"leek",10,12, new TypeEntity()),
            new IngredientEntity(5,false,true,"ice cream",10,12, new TypeEntity())
    ));
    private String lang = AppPropertiesReader.getInstance().getProperty("lang");

    public IngredientDaoMemory() {
        this.composedDao = new ComposedDaoMemory();
    }

    @Override
    public List<IngredientEntity> findAllIngredient() {
        List<IngredientEntity> ingredientEntityList = null;
        if (lang.equals("es")){
            ingredientEntityList=ingredientEntityList_es;
        } else if (lang.equals("en")) {
            ingredientEntityList=ingredientEntityList_en;
        }
        return ingredientEntityList;
    }

    @Override
    public IngredientEntity findByIdIngredient(Integer id) {
        List<IngredientEntity> ingredientEntityList = null;
        if (lang.equals("es")){
            ingredientEntityList=ingredientEntityList_es;
        } else if (lang.equals("en")) {
            ingredientEntityList=ingredientEntityList_en;
        }
        for (IngredientEntity ingredientEntity:ingredientEntityList){
            if (ingredientEntity.getId().equals(id)){
                return ingredientEntity;
            }
        }
        return null;
    }

    @Override
    public List<IngredientEntity> findByRecipe(Integer recipeId) {
        List<ComposedEntity> composedList = composedDao.findByRecipe(recipeId);
        List<IngredientEntity> requireIngredientList = new ArrayList<>();
        for (ComposedEntity composedEntity : composedList){
            requireIngredientList.add(findByIdIngredient(composedEntity.getIngredientId()));
        }
        return requireIngredientList;
    }

    @Override
    public void insert(IngredientEntity ingredientEntity) {
        if (lang.equals("es")){
            ingredientEntityList_es.add(ingredientEntity);
        } else if (lang.equals("en")) {
            ingredientEntityList_en.add(ingredientEntity);
        }
    }

    @Override
    public void delete(Integer id) {
        if (lang.equals("es")){
            ingredientEntityList_es.remove(findByIdIngredient(id));
        } else if (lang.equals("en")) {
            ingredientEntityList_en.remove(findByIdIngredient(id));
        }
    }

    @Override
    public List<IngredientEntity> findByType(int typeId) {
        return null;
    }
}
