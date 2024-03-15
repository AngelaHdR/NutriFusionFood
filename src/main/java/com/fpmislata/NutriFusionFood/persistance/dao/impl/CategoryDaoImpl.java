package com.fpmislata.NutriFusionFood.persistance.dao.impl;

import com.fpmislata.NutriFusionFood.persistance.dao.CategoryDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    //Aqui son List.of porque son inmutables, una forma de simular un enumerado mas facil
    List<CategoryEntity> categoryEntityList = List.of(
            new CategoryEntity(1,"salado"),
            new CategoryEntity(2,"postre"),
            new CategoryEntity(3,"bebida"),
            new CategoryEntity(4,"snack")
    );

    //No se pueden insertar ni borrar, solo buscar
    @Override
    public List<CategoryEntity> findAllCategory() {
        return categoryEntityList;
    }

    @Override
    public CategoryEntity findByIdCategory(Integer id) {
        for (CategoryEntity categoryEntity:categoryEntityList){
            if (categoryEntity.getId().equals(id)){
                return categoryEntity;
            }
        }
        return null;
    }
}
