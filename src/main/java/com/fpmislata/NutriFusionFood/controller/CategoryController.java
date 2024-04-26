package com.fpmislata.NutriFusionFood.controller;

import com.fpmislata.NutriFusionFood.common.container.CategoryIoC;
import com.fpmislata.NutriFusionFood.domain.service.CategoryService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/categories")
public class CategoryController {
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = CategoryIoC.getCategoryService();
    }

    @GetMapping("")
    public String findAllCategory(Model model) {
        model.addAttribute("categoryList",this.categoryService.findAllCategory());
        return "category";
    }

    @GetMapping("/{id]/recipes")
    public String findByIdCategory(Model model, @PathVariable Integer id) {
        model.addAttribute("category", this.categoryService.findByIdCategory(id));
        return "recipeList";
    }
}
