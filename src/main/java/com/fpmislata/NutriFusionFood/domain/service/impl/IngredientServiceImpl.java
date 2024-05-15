package com.fpmislata.NutriFusionFood.domain.service.impl;

import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.domain.service.IngredientService;
import com.fpmislata.NutriFusionFood.persistance.repository.IngredientRepository;

import java.util.List;

public class IngredientServiceImpl implements IngredientService {
    IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAllIngredient() {
        return ingredientRepository.findAllIngredient();
    }

    @Override
    public Ingredient findByIdIngredient(Integer id) {
        return ingredientRepository.findByIdIngredient(id);
    }

    @Override
    public List<Ingredient> findByType(int typeId) {
        return ingredientRepository.findByType(typeId);
    }
}
