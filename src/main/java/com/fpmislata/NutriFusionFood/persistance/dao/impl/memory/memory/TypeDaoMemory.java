package com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.memory;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.TypeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;

import java.util.List;

public class TypeDaoMemory implements TypeDao {
    //Aqui son List.of porque son inmutables, una forma de simular un enumerado mas facil
    List<TypeEntity> typeEntityList_es = List.of(
            new TypeEntity(1,"carne"),
            new TypeEntity(2,"pescado"),
            new TypeEntity(3,"lacteo"),
            new TypeEntity(4,"verdura"),
            new TypeEntity(5,"fruta"),
            new TypeEntity(6,"hidrados")
    );
    List<TypeEntity> typeEntityList_en = List.of(
            new TypeEntity(1,"meet"),
            new TypeEntity(2,"fish"),
            new TypeEntity(3,"dairy"),
            new TypeEntity(4,"vegetable"),
            new TypeEntity(5,"fruit"),
            new TypeEntity(6,"carbs")
    );

    private String lang = AppPropertiesReader.getInstance().getProperty("lang");

    //No se pueden insertar ni borrar, solo buscar
    @Override
    public List<TypeEntity> findAllType() {
        List<TypeEntity> typeEntityList=null;
        if (lang.equals("es")){
            typeEntityList=typeEntityList_es;
        } else if (lang.equals("en")) {
            typeEntityList=typeEntityList_en;
        }
        return typeEntityList;
    }

    @Override
    public TypeEntity findByIdType(Integer id) {
        List<TypeEntity> typeEntityList=null;
        if (lang.equals("es")){
            typeEntityList=typeEntityList_es;
        } else if (lang.equals("en")) {
            typeEntityList=typeEntityList_en;
        }
        for (TypeEntity typeEntity:typeEntityList){
            if (typeEntity.getId().equals(id)){
                return typeEntity;
            }
        }
        return null;
    }
}
