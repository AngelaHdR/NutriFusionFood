package com.fpmislata.NutriFusionFood.common.container;

import com.fpmislata.NutriFusionFood.domain.service.RecipeService;
import com.fpmislata.NutriFusionFood.domain.service.impl.RecipeServiceImpl;
import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.RecipeDaoImpl;
import com.fpmislata.NutriFusionFood.persistance.repository.RecipeRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.impl.RecipeRepositoryImpl;

public class RecipeIoC {
    private static RecipeService recipeService;
    private static RecipeRepository recipeRepository;
    private static RecipeDao recipeDao;
    public static RecipeService getRecipeService(){
        if (recipeService==null){
            recipeService = new RecipeServiceImpl(getRecipeRepository());
        }
        return recipeService;
    }
    public static RecipeRepository getRecipeRepository(){
        if (recipeRepository==null){
            recipeRepository = new RecipeRepositoryImpl(getRecipeDao());
        }
        return recipeRepository;
    }
    public static RecipeDao getRecipeDao(){
        if (recipeDao==null){
            recipeDao = new RecipeDaoImpl();
        }
        return recipeDao;
    }
}
