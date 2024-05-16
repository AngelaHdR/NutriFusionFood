package com.fpmislata.NutriFusionFood.controller;


import com.fpmislata.NutriFusionFood.common.container.*;
import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.entity.Type;
import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.domain.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/recipes")
public class RecipeController {
    RecipeService recipeService;
    CategoryService categoryService;

    IngredientService ingredientService;
    ToolService toolService;
    TypeService typeService;


        public RecipeController() {
            this.recipeService = RecipeIoC.getRecipeService();
            this.categoryService = CategoryIoC.getCategoryService();
            this.typeService = TypeIoC.getTypeService();
            this.toolService=ToolIoC.getToolService();
            this.ingredientService=IngredientIoC.getIngredientService();

        }
        @GetMapping("")
        public String findAllRecipe(Model model){
            model.addAttribute("recipeList", this.recipeService.findAllRecipe());
            model.addAttribute("category", "Todas las recetas");
            return "recipeList";
        }
        @GetMapping("/{id}")
        public String findByIdRecipe (Model model, @PathVariable Integer id){
            model.addAttribute("recipe", this.recipeService.findByIdRecipe(id));
            return "recipeDetail";
        }
        @GetMapping("/add")
        public String insert(Model model){
            List<Type> types = typeService.findAllType();
            Map<Type, List<Ingredient>> ingredientMap = new HashMap<>();
            for (Type type : types) {
                List<Ingredient> ingredients = ingredientService.findByType(type.getId());
                ingredientMap.put(type, ingredients);
            }
            model.addAttribute("ingredientMap", ingredientMap);
            /*model.addAttribute("typeList",this.typeService.findAllType());
            for (Type type : typeService.findAllType()) {
                model.addAttribute("ingredientList" + type.getName(), this.ingredientService.findByType(type.getId()));
            }*/
            model.addAttribute("toolList", this.toolService.findAllTool());
            model.addAttribute("categoryList", this.categoryService.findAllCategory());
            model.addAttribute("recipe", new Recipe());
            return "recipeForm";
        }
        @PostMapping("")
        public String save (Recipe recipe){
            UserService userService = UserIoC.getUserService();
            User user = new User();
            user.setId(userService.findAllNutritionist().size() + 1);
            recipe.setUser(user);
            recipeService.insert(recipe);
            return "redirect:/recipe";
        }
        @DeleteMapping("/{id}")
        public String delete (@PathVariable Integer id){
            recipeService.delete(id);
            return "redirect:/recipe";
        }
    }

