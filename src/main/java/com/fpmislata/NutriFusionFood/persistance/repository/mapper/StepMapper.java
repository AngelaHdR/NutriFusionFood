package com.fpmislata.NutriFusionFood.persistance.repository.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Step;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.StepEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StepMapper {
    public static List<StepEntity> toStepsEntityList(List<Step> stepList){
        List<StepEntity> steps = new ArrayList<>();
        for (Step step:stepList){
            steps.add(new StepEntity(step.getId(),step.getDescription()));
        }
        return steps;
    }
    public static List<Step> toStepsList(List<StepEntity> stepList){
        List<Step> steps = new ArrayList<>();
        for (StepEntity step:stepList){
            steps.add(new Step(step.getId(),step.getDescription()));
        }
        return steps;
    }
}
