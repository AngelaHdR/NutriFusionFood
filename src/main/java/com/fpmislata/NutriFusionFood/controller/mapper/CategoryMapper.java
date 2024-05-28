package com.fpmislata.NutriFusionFood.controller.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {
    public static Category toCategory(Integer categoryId) {
        return new Category(categoryId, null);
    }

    public static List<Category> toCategoryList(List<Integer> categoryIdList) {
        List<Category> categoryList = new ArrayList<>();
        for (Integer categoryId: categoryIdList) {
            categoryList.add(toCategory(categoryId));
        }
        return categoryList;
    }
}
