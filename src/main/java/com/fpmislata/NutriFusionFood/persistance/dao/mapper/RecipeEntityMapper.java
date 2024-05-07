package com.fpmislata.NutriFusionFood.persistance.dao.mapper;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;

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
                    resultSet.getString("steps"),
                    resultSet.getInt("time_recipe"),
                    resultSet.getInt("id_user"),
                    resultSet.getInt("id_category"));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
