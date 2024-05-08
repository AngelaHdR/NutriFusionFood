package com.fpmislata.NutriFusionFood.persistance.dao.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeEntityMapper {
    public static RecipeEntity toRecipeEntity(ResultSet resultSet){
        if (resultSet == null){
            return null;
        }
        try {
            return new RecipeEntity(
                    resultSet.getInt("r.id_recipe"),
                    resultSet.getString("r.name_recipe"),
                    resultSet.getString("r.lang"),
                    resultSet.getString("r.description_recipe"),
                    resultSet.getString("r.steps"),
                    resultSet.getInt("r.time_recipe"),
                    new UserEntity(resultSet.getInt("u.id_user"),
                            resultSet.getString("u.name_user"),
                            resultSet.getString("u.surname1"),
                            resultSet.getString("u.surname2"),
                            resultSet.getString("u.birth_date"),
                            resultSet.getBoolean("u.nutritionist"),
                            resultSet.getString("u.pwd"),
                            resultSet.getString("u.email"),
                            resultSet.getString("u.username")
                    ),
                    new CategoryEntity(resultSet.getInt("c.id_category"),
                            resultSet.getString("name")
                    )
            );
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
