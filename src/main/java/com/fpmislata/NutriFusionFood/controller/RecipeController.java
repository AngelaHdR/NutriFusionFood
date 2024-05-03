package com.fpmislata.NutriFusionFood.controller;

import com.fpmislata.NutriFusionFood.common.container.RecipeIoC;
import com.fpmislata.NutriFusionFood.common.container.UserIoC;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.domain.service.RecipeService;
import com.fpmislata.NutriFusionFood.domain.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
    RecipeService recipeService;

    public RecipeController() {
        this.recipeService = RecipeIoC.getRecipeService();
    }
    @GetMapping("")
    public String findAllRecipe(Model model){
        model.addAttribute("recipeList",this.recipeService.findAllRecipe());
        model.addAttribute("category","Todas las recetas");
        return "recipeList";
    }
    @GetMapping("/{id}")
    public String findByIdRecipe(Model model, @PathVariable Integer id){
        model.addAttribute("recipe", this.recipeService.findByIdRecipe(id));
        return "recipeDetail";
    }
    @GetMapping("/add")
    public String insert(Model model){

        model.addAttribute("recipe",new Recipe());
        return "recipeForm";
    }
    @PostMapping("")
    public String save(Recipe recipe){
        UserService userService = UserIoC.getUserService();
        User user = new User();
        user.setId(userService.findAllNutritionist().size()+1);
        recipe.setUser(user);
        recipeService.insert(recipe);
        return "redirect:/recipe";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        recipeService.delete(id);
        return "redirect:/recipe";
    }
}
