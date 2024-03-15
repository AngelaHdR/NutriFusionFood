package com.fpmislata.NutriFusionFood.common;

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
