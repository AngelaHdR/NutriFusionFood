package com.fpmislata.NutriFusionFood.persistance.repository.mapper;

import java.util.ArrayList;
import java.util.List;

import com.fpmislata.NutriFusionFood.domain.entity.Type;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;

public class TypeMapper {
    public static Type toType(TypeEntity typeEntity){
        if (typeEntity == null){
            return null;
        }
        return new Type(
                typeEntity.getId(),
                typeEntity.getName());
    }
    public static TypeEntity toTypeEntity(Type type){
        if (type == null){
            return null;
        }
        return new TypeEntity(
                type.getId(),
                type.getName());
    }
    public static List<Type> toTypeList(List<TypeEntity> typeEntityList){
        List<Type> typeList = new ArrayList<>();
        for(TypeEntity typeEntity:typeEntityList){
            typeList.add(toType(typeEntity));
        }
        return typeList;
    }
}
