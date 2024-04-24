package com.fpmislata.NutriFusionFood.persistance.dao.mapper;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeEntityMapper {
    public static TypeEntity toTypeEntity(ResultSet resultSet){
        if (resultSet == null){
            return null;
        }
        try {
            return new TypeEntity(resultSet.getInt("id_type"),resultSet.getString("name_es"),
                    resultSet.getString("name_en"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
