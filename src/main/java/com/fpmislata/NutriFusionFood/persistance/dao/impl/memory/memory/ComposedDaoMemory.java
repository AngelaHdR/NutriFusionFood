package com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.memory;

import com.fpmislata.NutriFusionFood.persistance.dao.ComposedDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ComposedEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComposedDaoMemory implements ComposedDao {
    List<ComposedEntity> composedEntityList = new ArrayList<>(Arrays.asList(
            new ComposedEntity(3, 2),
            new ComposedEntity(1, 4),
            new ComposedEntity(5, 5)
    ));
    @Override
    public List<ComposedEntity> findAll() {
        return composedEntityList;
    }

    @Override
    public List<ComposedEntity> findByRecipe(Integer recipeId) {
        List<ComposedEntity> composedRecipeList = new ArrayList<>();
        for (ComposedEntity composedEntity:composedEntityList){
            if (composedEntity.getRecipeId().equals(recipeId)){
                composedRecipeList.add(composedEntity);
            }
        }
        return composedRecipeList;
    }
}
