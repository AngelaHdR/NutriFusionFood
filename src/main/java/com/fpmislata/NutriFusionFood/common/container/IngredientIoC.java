package com.fpmislata.NutriFusionFood.common.container;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.IngredientDao;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.IngredientDaoJdbc;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.IngredientDaoMemory;

public class IngredientIoC {
    private static IngredientDao ingredientDao;
    public static IngredientDao getIngredientDao(){
        if (ingredientDao==null){
            if (AppPropertiesReader.getInstance().getProperty("daoimpl").equals("jdbc")){
                ingredientDao = new IngredientDaoJdbc();
            } else if (AppPropertiesReader.getInstance().getProperty("daoimpl").equals("memory")) {
                ingredientDao = new IngredientDaoMemory();
            }
        }
        return ingredientDao;
    }
}
