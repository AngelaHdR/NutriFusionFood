package com.fpmislata.NutriFusionFood.persistance.dao.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Category;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryEntityMapper {
    public static CategoryEntity toCategoryEntity(ResultSet resultSet){
        if(resultSet == null) {
            return null;
        }
        try {
            return new CategoryEntity(
                    resultSet.getInt("id_category"),
                    resultSet.getString("name"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
