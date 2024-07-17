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
        return "filters";
    }

    @PostMapping("")
    public String search(Model model, @RequestParam String allergen, @RequestParam Integer timeMin, @RequestParam Integer timeMax) {
        if (!allergen.isEmpty()) {
            return "redirect:/filters/allergens/{allergen}";
        } else if (timeMin != 0 || timeMax != 0) {
            return "redirect:/filters/time/{timeMin}_{timeMax}";
        } else {
            return "redirect:/recipes";
        }
    }

    @GetMapping("/allergens/{allergen}")
    public String findNoLactoseRecipe(Model model, @PathVariable String allergen) {
        model.addAttribute("recipeList", this.recipeService.findByAllergen(allergen));
        model.addAttribute("category", allergen.toUpperCase() + " FREE");
        return "recipeList";
    }

    @GetMapping("/time/{timeMin}_{timeMax}")
    public String findNoLactoseRecipe(Model model, @PathVariable Integer timeMin, @PathVariable Integer timeMax) {
        model.addAttribute("recipeList", this.recipeService.findByTime(timeMin, timeMax));
        model.addAttribute("category", timeMin+" - "+timeMax+" min");
        return "recipeList";
    }
}
