package com.fpmislata.NutriFusionFood.persistance.repository.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Type;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;

public class TypeMapper {
    public static Type toType(TypeEntity typeEntity){
        return new Type(typeEntity.getId(), typeEntity.getName_es(), typeEntity.getName_en());
    }
    public static TypeEntity toTypeEntity(Type type){
        return new TypeEntity(type.getId(),type.getName_es(), type.getName_en());
    }
}
