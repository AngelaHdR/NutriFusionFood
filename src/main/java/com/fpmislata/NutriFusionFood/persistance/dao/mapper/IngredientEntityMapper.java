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
                    resultSet.getInt("i.id_ingredient"),
                    resultSet.getBoolean("i.gluten"),
                    resultSet.getBoolean("i.lactose"),
                    resultSet.getString("i.name_"+lang),
                    resultSet.getInt("i.start_season"),
                    resultSet.getInt("i.end_season"),
                    new TypeEntity(
                            resultSet.getInt("t.id_type"),
                            resultSet.getString("t.name")
                    ));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

}
