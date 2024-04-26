package com.fpmislata.NutriFusionFood.persistance.repository;

import com.fpmislata.NutriFusionFood.domain.entity.Category;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;

import java.util.List;

public interface CategoryRepository {
    public List<Category> findAllCategory();
    public Category findByIdCategory(Integer id);
}
