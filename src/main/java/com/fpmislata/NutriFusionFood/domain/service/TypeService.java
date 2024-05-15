package com.fpmislata.NutriFusionFood.domain.service;

import java.util.List;

import com.fpmislata.NutriFusionFood.domain.entity.Type;

public interface TypeService {
    public List<Type> findAllType();
    public Type findByIdType(Integer id);
}
