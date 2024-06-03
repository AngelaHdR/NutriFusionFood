package com.fpmislata.NutriFusionFood.controller;

import com.fpmislata.NutriFusionFood.common.container.CategoryIoC;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/categories")
@Controller
public class CategoryController {
    CategoryService categoryService;

    public CategoryController() {
        this.categoryService = CategoryIoC.getCategoryService();
    }

    @GetMapping("/{id}/recipes")
    public String findRecipeByIdCategory(Model model, @PathVariable Integer id) {
        List<Recipe> recipeList = this.categoryService.findRecipeByCategory(id);
        model.addAttribute("recipeList", recipeList);
        String category=recipeList.get(0).getCategory().getName();
        model.addAttribute("category",category);
        return "recipeList";
    }

    /*
    Funcionalidad no implementada

    @GetMapping("")
    public String findAllCategory(Model model) {
        model.addAttribute("categoryList",this.categoryService.findAllCategory());
        return "category";
    }
     */
}