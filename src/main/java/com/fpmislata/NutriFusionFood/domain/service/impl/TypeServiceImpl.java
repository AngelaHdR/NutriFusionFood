package com.fpmislata.NutriFusionFood.domain.service.impl;

import java.util.List;

import com.fpmislata.NutriFusionFood.common.exceptions.BusinessException;
import com.fpmislata.NutriFusionFood.domain.entity.Type;
import com.fpmislata.NutriFusionFood.domain.service.TypeService;
import com.fpmislata.NutriFusionFood.persistance.repository.TypeRepository;

public class TypeServiceImpl implements TypeService{
    private TypeRepository typeRepository;
    public TypeServiceImpl(TypeRepository typeRepository){
        this.typeRepository = typeRepository;
    }

    @Override
    public List<Type> findAllType() {
        return this.typeRepository.findAllType();
    }

    @Override
    public Type findByIdType(Integer id) {
        Type type = this.typeRepository.findByIdType(id);
        if (type==null){
            throw new BusinessException("There is no recipe with id " + id);
        }
        return type;
    }
    
}
