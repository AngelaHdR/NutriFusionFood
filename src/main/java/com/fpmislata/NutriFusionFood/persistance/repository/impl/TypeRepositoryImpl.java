package com.fpmislata.NutriFusionFood.persistance.repository.impl;

import java.util.List;

import com.fpmislata.NutriFusionFood.domain.entity.Type;
import com.fpmislata.NutriFusionFood.persistance.dao.TypeDao;
import com.fpmislata.NutriFusionFood.persistance.repository.TypeRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.TypeMapper;

public class TypeRepositoryImpl implements TypeRepository{
    private TypeDao typeDao;
    public TypeRepositoryImpl(TypeDao typeDao){
        this.typeDao = typeDao;
    }

    @Override
    public List<Type> findAllType() {
        return TypeMapper.toTypeList(typeDao.findAllType());
    }

    @Override
    public Type findByIdType(Integer id) {
        return TypeMapper.toType(typeDao.findByIdType(id));
    }
    
}
