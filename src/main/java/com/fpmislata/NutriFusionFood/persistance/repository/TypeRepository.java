package com.fpmislata.NutriFusionFood.persistance.repository;

import java.util.List;

import com.fpmislata.NutriFusionFood.domain.entity.Type;

public interface TypeRepository {
    public List<Type> findAllType();
    public Type findByIdType(Integer id);
}
