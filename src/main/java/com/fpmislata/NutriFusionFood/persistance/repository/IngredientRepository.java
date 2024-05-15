package com.fpmislata.NutriFusionFood.persistance.repository;

import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;

import java.util.List;

public interface IngredientRepository {
    public List<Ingredient> findAllIngredient();
    public Ingredient findByIdIngredient(Integer id);
    public List<Ingredient> findByType(int typeId);
}
