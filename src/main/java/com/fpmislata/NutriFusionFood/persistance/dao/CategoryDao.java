package com.fpmislata.NutriFusionFood.persistance.dao;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    public List<CategoryEntity> findAllCategory();
    public CategoryEntity findByIdCategory(Integer id);
}
