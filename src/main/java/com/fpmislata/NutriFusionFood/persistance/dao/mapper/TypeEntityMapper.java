package com.fpmislata.NutriFusionFood.persistance.dao.mapper;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import org.springframework.context.i18n.LocaleContextHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class TypeEntityMapper {
    public static TypeEntity toTypeEntity(ResultSet resultSet){
        if (resultSet == null){
            return null;
        }
        try {
            return new TypeEntity(
                    resultSet.getInt("id_type"),
                    resultSet.getString("name"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
