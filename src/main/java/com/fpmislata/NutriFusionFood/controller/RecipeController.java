package com.fpmislata.NutriFusionFood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@GetMapping ("/recipes")
public class RecipeController {
    public String findAllRecipe(Model model){
        return "recipeList";
    }
    public String findByIdRecipe(Model model){
        return "recipeDetail";
    }
    public String newRecipe(Model model){
        return "recipeForm";
    }
    public String save(Recipe recipe){
        return "redirect:/recipe";
    }
    public String delete(@PathVariable Integer id){
        return "redirect:/recipe";
    }
    public String findByCategory(){
        return "recipeListCategory";
    }
    public String findAllCategories(){
        return "category";
    }
}
