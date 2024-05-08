package com.fpmislata.NutriFusionFood.common.container;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.domain.service.CategoryService;

import com.fpmislata.NutriFusionFood.domain.service.impl.CategoryServiceImpl;
import com.fpmislata.NutriFusionFood.persistance.dao.CategoryDao;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.CategoryDaoJdbc;
import antiguo.memory.CategoryDaoMemory;
import com.fpmislata.NutriFusionFood.persistance.repository.CategoryRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.impl.CategoryRepositoryImpl;

public class CategoryIoC {
    private static CategoryService categoryService;
    private static CategoryRepository categoryRepository;
    private static CategoryDao categoryDao;
    public static CategoryService getCategoryService(){
        if (categoryService == null){
            categoryService= new CategoryServiceImpl(getCategoryRepository());
        }
        return categoryService;
    }
    public static CategoryRepository getCategoryRepository(){
        if (categoryRepository == null){
            if (AppPropertiesReader.getInstance().getProperty("daoimpl").equals("jdbc")) {
                categoryRepository = new CategoryRepositoryImpl(getCategoryDao());
            }else if (AppPropertiesReader.getInstance().getProperty("daoimpl").equals("memory")) {
                categoryDao = new CategoryDaoMemory();
            }
        }
        return categoryRepository;
    }
    public static CategoryDao getCategoryDao(){
        if(categoryDao== null){

            categoryDao= new CategoryDaoJdbc();
        }
        return categoryDao;
    }
}
