package com.fpmislata.NutriFusionFood.persistance.repository.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Category;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {
    public static Category toCategory(CategoryEntity categoryEntity){
        if (categoryEntity == null){
            return null;
        }
        return new Category(
                categoryEntity.getId(),
                categoryEntity.getName());
    }

    public static CategoryEntity toCategoryEntity(Category category){
        if (category == null){
            return null;
        }
        return new CategoryEntity(
                category.getId(),
                category.getName());
    }
    public static List<Category> toCategoryList(List<CategoryEntity> categoryEntityList){
        List<Category> categoryList = new ArrayList<>();
        for (CategoryEntity categoryEntity:categoryEntityList){
            categoryList.add(toCategory(categoryEntity));
        }
        return categoryList;
    }
}
