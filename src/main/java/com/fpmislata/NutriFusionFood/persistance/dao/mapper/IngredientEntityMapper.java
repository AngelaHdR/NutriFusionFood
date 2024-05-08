package com.fpmislata.NutriFusionFood.persistance.dao.mapper;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientEntityMapper {

    public static IngredientEntity toIngredientEntity(ResultSet resultSet){
        String lang = AppPropertiesReader.getInstance().getProperty("lang");
        if(resultSet==null){
            return null;
        }
        try{
            return new IngredientEntity(
                    resultSet.getInt("id_ingredient"),
                    resultSet.getBoolean("gluten"),
                    resultSet.getBoolean("lactose"),
                    resultSet.getString("name_"+lang),
                    resultSet.getInt("start_season"),
                    resultSet.getInt("end_season"),
                    new TypeEntity(
                            resultSet.getInt("id_type"),
                            resultSet.getString("name")
                    ));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

}
