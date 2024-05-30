package com.fpmislata.NutriFusionFood.common.container;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.domain.service.IngredientService;
import com.fpmislata.NutriFusionFood.domain.service.impl.IngredientServiceImpl;
import com.fpmislata.NutriFusionFood.persistance.dao.IngredientDao;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.IngredientDaoJdbc;
import com.fpmislata.NutriFusionFood.persistance.repository.IngredientRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.impl.IngredientRepositoryImpl;


public class IngredientIoC {
    private static IngredientDao ingredientDao;
    private static IngredientRepository ingredientRepository;
    private static IngredientService ingredientService;
    public static IngredientDao getIngredientDao(){
        if (ingredientDao==null){
            if (AppPropertiesReader.getInstance().getProperty("daoimpl").equals("jdbc")){
                ingredientDao = new IngredientDaoJdbc();
            }
        }
        return ingredientDao;
    }

    public static void setIngredientDao(IngredientDao ingredientDao) {
        IngredientIoC.ingredientDao = ingredientDao;
    }

    public static IngredientRepository getIngredientRepository() {
        if (ingredientRepository==null){
            ingredientRepository = new IngredientRepositoryImpl(getIngredientDao());
        }
        return ingredientRepository;
    }

    public static void setIngredientRepository(IngredientRepository ingredientRepository) {
        IngredientIoC.ingredientRepository = ingredientRepository;
    }

    public static IngredientService getIngredientService() {
        if (ingredientService==null){
            ingredientService = new IngredientServiceImpl(getIngredientRepository());
        }
        return ingredientService;
    }

    public static void setIngredientService(IngredientService ingredientService) {
        IngredientIoC.ingredientService = ingredientService;
    }
}
