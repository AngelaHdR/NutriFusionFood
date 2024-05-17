package com.fpmislata.NutriFusionFood.persistance.dao.mapper;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ToolEntityMapper {
    public static ToolEntity toToolEntity(ResultSet resultSet,String lang){
        //String lang = AppPropertiesReader.getInstance().getProperty("lang");
        if (resultSet == null){
            return null;
        }
        try {
            return new ToolEntity(
                    resultSet.getInt("id_tool"),
                    resultSet.getString("name_"+lang));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
