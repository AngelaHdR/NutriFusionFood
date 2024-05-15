package com.fpmislata.NutriFusionFood.domain.service.impl;

import com.fpmislata.NutriFusionFood.common.container.RecipeIoC;
import com.fpmislata.NutriFusionFood.common.exceptions.ServiceException;
import com.fpmislata.NutriFusionFood.domain.entity.Category;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.service.CategoryService;
import com.fpmislata.NutriFusionFood.persistance.repository.CategoryRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.RecipeRepository;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository=categoryRepository;
        this.recipeRepository= RecipeIoC.getRecipeRepository();
    }

    @Override
    public List<Category> findAllCategory() {
        List<Category> categoryList= this.categoryRepository.findAllCategory();
        if (categoryList.isEmpty()){
            throw new ServiceException("The list of categories is empty");
        }
        return categoryList;
    }

    @Override
    public Category findByIdCategory(Integer id) {
        Category category = this.categoryRepository.findByIdCategory(id);
        if (category==null){
            throw new ServiceException("There is no category with id: " + id);
        }
        return category;
    }

    @Override
    public List<Recipe> findRecipeByCategory(Integer id) {
        return this.recipeRepository.findByCategory(id);
    }
}
