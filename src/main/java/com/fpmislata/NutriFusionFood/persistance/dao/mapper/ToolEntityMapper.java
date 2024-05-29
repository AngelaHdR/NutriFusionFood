package com.fpmislata.NutriFusionFood.persistance.dao.mapper;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ToolEntityMapper {
    public static ToolEntity toToolEntity(ResultSet resultSet){
        if (resultSet == null){
            return null;
        }
        try {
            return new ToolEntity(
                    resultSet.getInt("id_tool"),
                    resultSet.getString("name"));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
