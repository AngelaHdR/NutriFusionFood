package com.fpmislata.NutriFusionFood.persistance.dao;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;

import java.util.List;

public interface TypeDao {
    public List<TypeEntity> findAllType();
    public TypeEntity findByIdType(Integer id);
}
