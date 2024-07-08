package com.fpmislata.NutriFusionFood.controller.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Step;

import java.util.ArrayList;
import java.util.List;

public class StepsMapper {
    public static List<Step> toStepUpdate(String step){
        List<Step> stepList = new ArrayList<>();
        step=step.substring(1,step.length()-2);
        String[] steps = step.split("/,");

        int i =1;
        for(String step1:steps){
            if (step1.length()>2){
                stepList.add(new Step(i,step1));
                i+=1;
            }

        }
        return stepList;
    }
    public static List<Step> toStepSave(String step){
        List<Step> stepList = new ArrayList<>();
        String[] steps = step.split("\n");

        int i =1;
        for(String step1:steps){
            stepList.add(new Step(i,step1));
            i+=1;
        }
        return stepList;
    }
}
