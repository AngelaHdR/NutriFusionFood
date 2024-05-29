package com.fpmislata.NutriFusionFood.persistance.dao.mapper;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import org.springframework.context.i18n.LocaleContextHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class IngredientEntityMapper {

    public static IngredientEntity toIngredientEntity(ResultSet resultSet,String lang){
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
