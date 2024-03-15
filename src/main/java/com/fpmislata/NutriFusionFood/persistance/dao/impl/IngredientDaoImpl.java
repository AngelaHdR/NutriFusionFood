package com.fpmislata.NutriFusionFood.persistance.dao.impl;

import com.fpmislata.NutriFusionFood.persistance.dao.IngredientDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IngredientDaoImpl implements IngredientDao {
    List<IngredientEntity> ingredientEntityList = new ArrayList<>(Arrays.asList(
            new IngredientEntity(1,true,false,"harina",10,12, 6)
    ));
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
    public void insert(IngredientEntity ingredientEntity) {
        ingredientEntityList.add(ingredientEntity);
    }

    @Override
    public void delete(Integer id) {
        ingredientEntityList.remove(findByIdIngredient(id));
    }
}
