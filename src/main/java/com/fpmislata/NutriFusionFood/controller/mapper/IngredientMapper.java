package com.fpmislata.NutriFusionFood.controller.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class IngredientMapper {
    public static Ingredient toIngredient(Integer ingredientId){
        return new Ingredient(ingredientId);
    }
    public static List<Ingredient> toIngredientList(List<Integer> ingredientIdList){
        List<Ingredient> ingredientList = new ArrayList<>();
        for (Integer integer:ingredientIdList){
            ingredientList.add(toIngredient(integer));
        }
        return ingredientList;
    }
}
