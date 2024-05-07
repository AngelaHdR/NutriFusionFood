package com.fpmislata.NutriFusionFood.persistance.dao.mapper;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeEntityMapper {
    public static TypeEntity toTypeEntity(ResultSet resultSet){
        String lang = AppPropertiesReader.getInstance().getProperty("lang");
        if (resultSet == null){
            return null;
        }
        try {
            return new TypeEntity(
                    resultSet.getInt("id_type"),
                    resultSet.getString("name_"+lang));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
