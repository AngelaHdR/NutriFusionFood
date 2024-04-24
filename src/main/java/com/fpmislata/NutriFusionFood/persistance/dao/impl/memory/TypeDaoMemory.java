package com.fpmislata.NutriFusionFood.persistance.dao.impl.memory;

import com.fpmislata.NutriFusionFood.persistance.dao.TypeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;

import java.util.List;

public class TypeDaoMemory implements TypeDao {
    //Aqui son List.of porque son inmutables, una forma de simular un enumerado mas facil
    List<TypeEntity> typeEntityList = List.of(
            new TypeEntity(1,"carne","meet"),
            new TypeEntity(2,"pescado","fish"),
            new TypeEntity(3,"lacteo","dairy"),
            new TypeEntity(4,"verdura","vegetable"),
            new TypeEntity(5,"fruta","fruit"),
            new TypeEntity(6,"hidrados","carbs")
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
