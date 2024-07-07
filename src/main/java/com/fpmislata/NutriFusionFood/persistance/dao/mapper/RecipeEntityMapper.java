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
                    resultSet.getInt("id_recipe"),
                    resultSet.getString("name_recipe"),
                    resultSet.getString("lang"),
                    resultSet.getString("description_recipe"),
                    resultSet.getInt("time_recipe"),
                    new UserEntity(resultSet.getInt("id_user"),
                            resultSet.getString("name_user"),
                            resultSet.getString("surname1"),
                            resultSet.getString("surname2"),
                            resultSet.getString("birth_date"),
                            resultSet.getBoolean("nutritionist"),
                            resultSet.getString("pwd"),
                            resultSet.getString("email"),
                            resultSet.getString("username")
                    ),
                    new CategoryEntity(resultSet.getInt("id_category"),
                            resultSet.getString("name")
                    )
            );
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
