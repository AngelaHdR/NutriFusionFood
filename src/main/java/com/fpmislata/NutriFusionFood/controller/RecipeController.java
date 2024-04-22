package com.fpmislata.NutriFusionFood.controller;

import com.fpmislata.NutriFusionFood.common.RecipeIoC;
import com.fpmislata.NutriFusionFood.common.UserIoC;
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

    @GetMapping("/categories/{id}")
    public String findByCategory(@PathVariable Integer id, Model model){
        List<Recipe> recipeList = this.recipeService.findByCategory(id);
        model.addAttribute("recipeList",recipeList);
        String category=recipeList.get(0).getCategory().getName_es();
        model.addAttribute("category",category);
        return "recipeList";
    }
    @GetMapping("/categories")
    public String findAllCategories(){
        return "category";
    }
}
