package com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.memory;

import com.fpmislata.NutriFusionFood.persistance.dao.RequireDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RequireEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequireDaoMemory implements RequireDao {
    List<RequireEntity> requireEntityList = new ArrayList<>(Arrays.asList(
            new RequireEntity(3, 1),
            new RequireEntity(4, 3),
            new RequireEntity(1, 4)
    ));

    @Override
    public List<RequireEntity> findAll() {
        return requireEntityList;
    }

    @Override
    public List<RequireEntity> findByRecipe(Integer recipeId) {
        List<RequireEntity> requireRecipeList = new ArrayList<>();
        for (RequireEntity requireEntity: requireEntityList){
            if (requireEntity.getRecipeId().equals(recipeId)){
                requireRecipeList.add(requireEntity);
            }
        }
        return requireRecipeList;
    }
}
