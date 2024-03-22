package com.fpmislata.NutriFusionFood.persistance.dao.impl;

import com.fpmislata.NutriFusionFood.persistance.dao.ComposedDao;
import com.fpmislata.NutriFusionFood.persistance.dao.IngredientDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ComposedEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IngredientDaoImpl implements IngredientDao {
    private ComposedDao composedDao;

    List<IngredientEntity> ingredientEntityList = new ArrayList<>(Arrays.asList(
            new IngredientEntity(1,true,false,"pan",10,12, 6),
            new IngredientEntity(2,false,false,"pollo",10,12, 1),
            new IngredientEntity(3,false,false,"tomate",10,12, 5),
            new IngredientEntity(4,false,false,"puerro",10,12, 4),
            new IngredientEntity(5,false,true,"helado",10,12, 3)
    ));

    public IngredientDaoImpl() {
        this.composedDao = new ComposedDaoImpl();
    }

    @Override
    public List<IngredientEntity> findAllIngredient() {
        return ingredientEntityList;
    }

    @Override
    public IngredientEntity findByIdIngredient(Integer id) {
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
        ingredientEntityList.add(ingredientEntity);
    }

    @Override
    public void delete(Integer id) {
        ingredientEntityList.remove(findByIdIngredient(id));
    }
}
