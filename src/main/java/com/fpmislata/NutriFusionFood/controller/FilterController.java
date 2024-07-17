package com.fpmislata.NutriFusionFood.controller;

import com.fpmislata.NutriFusionFood.common.Auth;
import com.fpmislata.NutriFusionFood.common.container.RecipeIoC;
import com.fpmislata.NutriFusionFood.domain.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recipes")
public class FilterController {
    RecipeService recipeService;

    public FilterController() {
        this.recipeService = RecipeIoC.getRecipeService();
    }

    @GetMapping("/filters")
    public String findAllFilters(Model model) {
        //model.addAttribute("timeMin",this.recipeService.findTimeMin());
        model.addAttribute("timeMin",5);
        //model.addAttribute("timeMax",this.recipeService.findTimeMax());
        model.addAttribute("timeMax",200);
        model.addAttribute("allergenList",this.recipeService.findByIdRecipe(1).getAllergen());
        return "filters";
    }

    /*@PostMapping("/search")
    public String search(Model model, @RequestParam String allergen, @RequestParam Integer timeMin, @RequestParam Integer timeMax) {
        if (allergen.equals("null")) {
            return "redirect:/recipes/time";
        } else {
            return "redirect:/recipes/allergens/{allergen}";
        }
    }
    @GetMapping("/allergens/{allergen}")
    public String findAllergenRecipe(Model model, @PathVariable String allergen) {
        model.addAttribute("recipeList", this.recipeService.findByAllergen(allergen));
        model.addAttribute("category", allergen.toUpperCase() + " FREE");
        return "recipeList";
    }
    @GetMapping("/time")
    public String findTimeRecipe(Model model, @RequestParam Integer timeMin, @RequestParam Integer timeMax) {
        model.addAttribute("recipeList", this.recipeService.findByTime(timeMin, timeMax));
        model.addAttribute("category", timeMin+" - "+timeMax+" min");
        return "recipeList";
    }*/

    @PostMapping("/allergens")
    public String findByAllergenRecipe(Model model, @RequestParam String allergen) {
        model.addAttribute("recipeList", this.recipeService.findByAllergen(allergen));
        model.addAttribute("category", allergen.toUpperCase() + " FREE");
        return "recipeList";
    }

    @PostMapping("/time")
    public String findByTimeRecipe(Model model, @RequestParam Integer timeMin, @RequestParam Integer timeMax) {
        model.addAttribute("recipeList", this.recipeService.findByTime(timeMin, timeMax));
        model.addAttribute("category", timeMin+" - "+timeMax+" min");
        return "recipeList";
    }
}
