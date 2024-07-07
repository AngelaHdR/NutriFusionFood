package com.fpmislata.NutriFusionFood.persistance.dao.mapper;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.StepEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StepsMapper {
    public static List<StepEntity> toStepsList(ResultSet resultSet){
        List<StepEntity> steps = new ArrayList<>();
        try {
            while (resultSet.next()){
                steps.add(new StepEntity(
                        resultSet.getInt("id_step"),
                        resultSet.getString("description_step")
                ));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return steps;
    }
}
