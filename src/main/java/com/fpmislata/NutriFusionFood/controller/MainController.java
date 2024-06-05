package com.fpmislata.NutriFusionFood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fpmislata.NutriFusionFood.common.container.CategoryIoC;
import com.fpmislata.NutriFusionFood.domain.service.CategoryService;

@Controller
public class MainController {

    CategoryService categoryService;

    public MainController() {
        this.categoryService = CategoryIoC.getCategoryService();
    }

    @GetMapping("")
    public String showMainPage(Model model) {
        model.addAttribute("categoryList", categoryService.findAllCategory());
        return "home";
    }
}
