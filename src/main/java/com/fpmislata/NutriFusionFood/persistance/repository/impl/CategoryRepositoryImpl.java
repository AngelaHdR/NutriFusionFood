package com.fpmislata.NutriFusionFood.persistance.repository.impl;

import com.fpmislata.NutriFusionFood.domain.entity.Category;
import com.fpmislata.NutriFusionFood.persistance.dao.CategoryDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import com.fpmislata.NutriFusionFood.persistance.repository.CategoryRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.CategoryMapper;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    private CategoryDao categoryDao;

    public CategoryRepositoryImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> findAllCategory() {
        List<CategoryEntity> categoryEntityList = categoryDao.findAllCategory();
        List<Category> categoryList = new ArrayList<>();
        for (CategoryEntity categoryEntity:categoryEntityList) {
            categoryList.add(findByIdCategory(categoryEntity.getId()));
        }
        return categoryList;
    }

    @Override
    public Category findByIdCategory(Integer id) {
        CategoryEntity categoryEntity = categoryDao.findByIdCategory(id);
        Category category = CategoryMapper.toCategory(categoryEntity);
        return category;
    }
}
