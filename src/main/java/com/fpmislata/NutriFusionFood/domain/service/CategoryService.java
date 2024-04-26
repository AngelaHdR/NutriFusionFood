package com.fpmislata.NutriFusionFood.domain.service;

import com.fpmislata.NutriFusionFood.domain.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAllCategory();
    public Category findByIdCategory(Integer id);
}
