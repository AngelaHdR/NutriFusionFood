package com.fpmislata.NutriFusionFood.persistance.dao.impl.memory;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.CategoryDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoMemory implements CategoryDao {
    //Aqui son List.of porque son inmutables, una forma de simular un enumerado mas facil
    List<CategoryEntity> categoryEntityList_es = List.of(
            new CategoryEntity(1,"salado"),
            new CategoryEntity(2,"postre"),
            new CategoryEntity(3,"bebida"),
            new CategoryEntity(4,"snack")
    );
    List<CategoryEntity> categoryEntityList_en = List.of(
            new CategoryEntity(1,"main dish"),
            new CategoryEntity(2,"dessert"),
            new CategoryEntity(3,"drink"),
            new CategoryEntity(4,"snack")
    );
    private final AppPropertiesReader appPropertiesReader = AppPropertiesReader.getInstance();
    private String lang;
    public CategoryDaoMemory(){
        System.out.println("Changing the language...");
        try {
            lang = appPropertiesReader.getProperty("lang");
            System.out.println("Language changed to: " + lang);
        } catch (Exception e) {
            throw new RuntimeException("Error changing language");
        }
    }

    //No se pueden insertar ni borrar, solo buscar
    @Override
    public List<CategoryEntity> findAllCategory() {
        List<CategoryEntity> categoryEntityList = null;
        if (lang.equals("es")){
            categoryEntityList=categoryEntityList_es;
        } else if (lang.equals("en")) {
            categoryEntityList=categoryEntityList_en;
        }
        return categoryEntityList;
    }

    @Override
    public CategoryEntity findByIdCategory(Integer id) {
        List<CategoryEntity> categoryEntityList = null;
        if (lang.equals("es")){
            categoryEntityList=categoryEntityList_es;
        } else if (lang.equals("en")) {
            categoryEntityList=categoryEntityList_en;
        }
        for (CategoryEntity categoryEntity:categoryEntityList){
            if (categoryEntity.getId().equals(id)){
                return categoryEntity;
            }
        }
        return null;
    }
}
