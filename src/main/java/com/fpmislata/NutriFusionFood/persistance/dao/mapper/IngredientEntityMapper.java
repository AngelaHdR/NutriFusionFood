package com.fpmislata.NutriFusionFood.persistance.dao.mapper;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientEntityMapper {

    public static IngredientEntity toIngredientEntity(ResultSet resultSet){
        if(resultSet==null){
            return null;
        }
        try{
            return new IngredientEntity(resultSet.getInt("id_ingredient"), resultSet.getBoolean("gluten"),resultSet.getBoolean("lactose"),
                    resultSet.getString("name_es"),resultSet.getString("name_en"),
                    resultSet.getInt("start_season"),resultSet.getInt("end_season"),resultSet.getInt("id_type"));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

}
