package com.fpmislata.NutriFusionFood.persistance.repository.impl;

import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.persistance.dao.IngredientDao;
import com.fpmislata.NutriFusionFood.persistance.repository.IngredientRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.IngredientMapper;

import java.util.List;

public class IngredientRepositoryImpl implements IngredientRepository {
    IngredientDao ingredientDao;

    public IngredientRepositoryImpl(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    @Override
    public List<Ingredient> findAllIngredient() {
        return IngredientMapper.toIngredientList(ingredientDao.findAllIngredient());
    }

    @Override
    public Ingredient findByIdIngredient(Integer id) {
        return IngredientMapper.toIngredient(ingredientDao.findByIdIngredient(id));
    }

    @Override
    public List<Ingredient> findByType(int typeId) {
        return IngredientMapper.toIngredientList(ingredientDao.findByType(typeId));
    }
}
