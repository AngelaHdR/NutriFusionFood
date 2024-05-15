package com.fpmislata.NutriFusionFood.domain.service;

import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    public List<Ingredient> findAllIngredient();
    public Ingredient findByIdIngredient(Integer id);
}
