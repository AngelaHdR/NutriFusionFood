package com.fpmislata.NutriFusionFood.common.container;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.domain.service.RecipeService;
import com.fpmislata.NutriFusionFood.domain.service.impl.RecipeServiceImpl;
import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.RecipeDaoJdbc;
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
            if (AppPropertiesReader.getInstance().getProperty("daoimpl").equals("jdbc")){
                recipeDao = new RecipeDaoJdbc();
            }
        }
        return recipeDao;
    }
    public static void setRecipeService(RecipeService recipeService) {
        RecipeIoC.recipeService = recipeService;
    }
    public static void setRecipeRepository(RecipeRepository recipeRepository) {
        RecipeIoC.recipeRepository = recipeRepository;
    }
    public static void setRecipeDao(RecipeDao recipeDao) {
        RecipeIoC.recipeDao = recipeDao;
    }
    public static void reset() {
        recipeService = null;
        recipeRepository = null;
        recipeDao = null;
    }
}
