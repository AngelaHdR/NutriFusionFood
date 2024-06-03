package com.fpmislata.NutriFusionFood.persistance.repository.impl;

import com.fpmislata.NutriFusionFood.domain.entity.Category;
import com.fpmislata.NutriFusionFood.persistance.dao.CategoryDao;
import com.fpmislata.NutriFusionFood.persistance.repository.CategoryRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.CategoryMapper;

import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    private CategoryDao categoryDao;

    public CategoryRepositoryImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> findAllCategory() {
        return CategoryMapper.toCategoryList(categoryDao.findAllCategory());
    }

    @Override
    public Category findByIdCategory(Integer id) {
        return CategoryMapper.toCategory(categoryDao.findByIdCategory(id));
    }
}
