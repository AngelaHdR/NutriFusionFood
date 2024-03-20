package com.fpmislata.NutriFusionFood.controller;

import com.fpmislata.NutriFusionFood.common.UserIoC;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.domain.service.RecipeService;
import com.fpmislata.NutriFusionFood.domain.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
    RecipeService recipeService;

    public RecipeController() {
        this.recipeService = recipeService;
    }
    @GetMapping("/recipeList")
    public String findAllRecipe(Model model){
        model.addAttribute("recipelist",this.recipeService.findAllRecipe());
        return "recipeList";
    }
    @GetMapping("/{id}")
    public String findByIdRecipe(Model model, @PathVariable Integer id){
        model.addAttribute("recipeid", this.recipeService.findByIdRecipe(id));
        return "recipeDetail";
    }
    @GetMapping("/add")
    public String newRecipe(Model model){
        UserService userService = UserIoC.getUserService();
        model.addAttribute("userlist",userService.findAllUser());
        model.addAttribute("recipe",new Recipe());
        return "recipeForm";
    }
    @PostMapping("")
    public String save(Recipe recipe){
        UserService userService = UserIoC.getUserService();
        User user = new User();
        user.setId(userService.findAllUser().size()+1);
        recipe.setUser(user);
        recipeService.insert(recipe);
        return "redirect:/recipe";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        recipeService.delete(id);
        return "redirect:/recipe";
    }

    @GetMapping("/categories/{categoryId}")
    public String findByCategory(@PathVariable Integer id){
        recipeService.findByCategory(id);
        return "recipeListCategory";
    }
    @GetMapping("/categories")
    public String findAllCategories(){
        return "category";
    }
}
