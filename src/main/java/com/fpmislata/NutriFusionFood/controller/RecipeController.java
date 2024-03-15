package com.fpmislata.NutriFusionFood.controller;

import com.fpmislata.NutriFusionFood.common.UserIoC;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.domain.service.RecipeService;
import com.fpmislata.NutriFusionFood.domain.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@GetMapping ("/recipes")
public class RecipeController {
    RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
@GetMapping
    public String findAllRecipe(Model model){
        model.addAttribute("recipelist",this.recipeService.findAllRecipe());
        return "recipeList";
    }
    public String findByIdRecipe(Model model){
        model.addAttribute("recipeid", this.recipeService.findByIdRecipe(id));
        return "recipeDetail";
    }
    public String newRecipe(Model model){
        UserService userService = UserIoC.getUserService();
        model.addAttribute("userlist",userService.findAllUser());
        model.addAttribute("recipe",new Recipe());
        return "recipeForm";
    }
    public String save(Recipe recipe){
        UserService userService = UserIoC.getUserService();
        User user = new User();
        user.setId(userService.findAllUser().size()+1);
        recipe.setUser(user);
        recipeService.insert(recipe);
        return "redirect:/recipe";
    }
    public String delete(@PathVariable Integer id){
        recipeService.delete(id);
        return "redirect:/recipe";
    }
    public String findByCategory(){

        return "recipeListCategory";
    }
    public String findAllCategories(){
        return "category";
    }
}
