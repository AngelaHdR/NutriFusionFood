package com.fpmislata.NutriFusionFood.persistance.dao.mapper;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserEntityMapper {
    public static UserEntity toUserEntity(ResultSet resultSet){
        if (resultSet == null) {
            return null;
        }
        try {
            return new UserEntity(
                    resultSet.getInt("id_user"),
                    resultSet.getString("name_user"),
                    resultSet.getString("surname1"),
                    resultSet.getString("surname2"),
                    resultSet.getString("birth_date"),
                    resultSet.getBoolean("nutritionist"),
                    resultSet.getString("pwd"),
                    resultSet.getString("email"),
                    resultSet.getString("username"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
