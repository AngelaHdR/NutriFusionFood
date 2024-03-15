package com.fpmislata.NutriFusionFood.persistance.dao.impl;

import com.fpmislata.NutriFusionFood.persistance.dao.TypeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;

import java.util.List;

public class TypeDaoImpl implements TypeDao {
    //Aqui son List.of porque son inmutables, una forma de simular un enumerado mas facil
    List<TypeEntity> typeEntityList = List.of(
            new TypeEntity(1,"carne"),
            new TypeEntity(2,"pescado"),
            new TypeEntity(3,"lacteo"),
            new TypeEntity(4,"verdura"),
            new TypeEntity(5,"fruta"),
            new TypeEntity(6,"hidrados")
    );

    //No se pueden insertar ni borrar, solo buscar
    @Override
    public List<TypeEntity> findAllType() {
        return typeEntityList;
    }

    @Override
    public TypeEntity findByIdType(Integer id) {
        for (TypeEntity typeEntity:typeEntityList){
            if (typeEntity.getId().equals(id)){
                return typeEntity;
            }
        }
        return null;
    }
}
