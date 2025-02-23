package com.fpmislata.NutriFusionFood.controller;


import com.fpmislata.NutriFusionFood.common.Auth;
import com.fpmislata.NutriFusionFood.common.container.*;
import com.fpmislata.NutriFusionFood.controller.mapper.CategoryMapper;
import com.fpmislata.NutriFusionFood.controller.mapper.IngredientMapper;
import com.fpmislata.NutriFusionFood.controller.mapper.StepsMapper;
import com.fpmislata.NutriFusionFood.controller.mapper.ToolMapper;
import com.fpmislata.NutriFusionFood.domain.entity.Ingredient;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.entity.Type;
import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.domain.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    UserService userService;


    public RecipeController() {
        this.recipeService = RecipeIoC.getRecipeService();
        this.categoryService = CategoryIoC.getCategoryService();
        this.typeService = TypeIoC.getTypeService();
        this.toolService = ToolIoC.getToolService();
        this.ingredientService = IngredientIoC.getIngredientService();
        this.userService = UserIoC.getUserService();
    }

    @GetMapping("")
    public String findAllRecipe(Model model) {
        model.addAttribute("recipeList", this.recipeService.findAllRecipe());
        model.addAttribute("category", null);
        return "recipes/recipeList";
    }

    @GetMapping("/{id}")
    public String findByIdRecipe(Model model, @PathVariable Integer id) {
        if (Auth.getUser().getId()==null){
            return "redirect:/users/login/add";
        }
        model.addAttribute("recipe", this.recipeService.findByIdRecipe(id));
        if (this.userService.findFavoritesByUser(Auth.getUser().getId()).contains(recipeService.findByIdRecipe(id))) {
            model.addAttribute("favorite", true);
        }else{
            model.addAttribute("favorite", false);
        }
        return "recipes/recipeDetail";
    }

    @GetMapping("/add")
    public String insert(Model model) {
        if (Auth.getUser().getId()==null){
            return "redirect:/users/login/add";
        }
        List<Type> types = typeService.findAllType();
        Map<Type, List<Ingredient>> ingredientMap = new HashMap<>();
        for (Type type : types) {
            List<Ingredient> ingredients = ingredientService.findByType(type.getId());
            ingredientMap.put(type, ingredients);
        }
        model.addAttribute("ingredientMap", ingredientMap);
        model.addAttribute("toolList", this.toolService.findAllTool());
        model.addAttribute("categoryList", this.categoryService.findAllCategory());
        model.addAttribute("lang", List.of("es", "en"));
        model.addAttribute("recipe", new Recipe());
        return "recipes/recipeForm";
    }

    @PostMapping("")
    public String save(Recipe recipe, @RequestParam List<Integer> toolIdList,
                       @RequestParam List<Integer> typeIdList, @RequestParam Integer categoryId,
                       @RequestParam String stepsDescription) {
        UserService userService = UserIoC.getUserService();
        recipe.setUser(userService.findByIdUser(Auth.getUser().getId()));
        recipe.setId(recipeService.findAllRecipe().size());
        recipe.setCategory(CategoryMapper.toCategory(categoryId));
        recipe.setToolList(ToolMapper.toToolList(toolIdList));
        recipe.setIngredientList(IngredientMapper.toIngredientList(typeIdList));
        recipe.setSteps(StepsMapper.toStepSave(stepsDescription));
        System.out.println(recipe);
        recipeService.insert(recipe);

        return "redirect:/recipes";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        recipeService.delete(id);
        return "redirect:/recipes";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        if (Auth.getUser().getId()==null){
            return "redirect:/users/login/add";
        }
        Recipe recipe = recipeService.findByIdRecipe(id);
        List<Type> types = typeService.findAllType();
        Map<Type, List<Ingredient>> ingredientMap = new HashMap<>();
        for (Type type : types) {
            List<Ingredient> ingredients = ingredientService.findByType(type.getId());
            ingredientMap.put(type, ingredients);
        }
        model.addAttribute("ingredientMap", ingredientMap);
        model.addAttribute("toolList", toolService.findAllTool());
        model.addAttribute("categoryList", categoryService.findAllCategory());
        model.addAttribute("lang", List.of("es", "en"));
        model.addAttribute("recipe", recipe);
        return "recipes/recipeUpdate";
    }

    @PutMapping("/update/{id}")
    public String updateRecipe(@PathVariable int id, @ModelAttribute Recipe recipe, BindingResult result, Model model,
                               @RequestParam List<Integer> toolIdList, @RequestParam List<Integer> typeIdList,
                               @RequestParam Integer categoryId, @RequestParam String steps) {

        UserService userService = UserIoC.getUserService();
        recipe.setUser(userService.findByIdUser(Auth.getUser().getId()));
        recipe.setCategory(CategoryMapper.toCategory(categoryId));
        recipe.setToolList(ToolMapper.toToolList(toolIdList));
        recipe.setIngredientList(IngredientMapper.toIngredientList(typeIdList));
        recipe.setSteps(StepsMapper.toStepUpdate(steps));
        System.out.println(recipe);
        recipeService.update(recipe);
        return "redirect:/recipes";
    }
    @PostMapping("/{id}")
    public String modifyFavorites(@PathVariable Integer id, @RequestParam Boolean status){
        Integer userId = Auth.getUser().getId();
        this.recipeService.modifyFavorites(id, status, userId);
        return "redirect:/recipes/{id}";
    }
}

