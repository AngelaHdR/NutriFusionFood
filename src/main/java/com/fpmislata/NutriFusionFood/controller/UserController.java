package com.fpmislata.NutriFusionFood.controller;

import com.fpmislata.NutriFusionFood.common.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fpmislata.NutriFusionFood.domain.entity.User;

import com.fpmislata.NutriFusionFood.common.container.UserIoC;
import com.fpmislata.NutriFusionFood.domain.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    UserService userService;
    public UserController(){
        this.userService = UserIoC.getUserService();
    }

    @GetMapping("/nutritionists/{id}")
    public String findByIdNutritionist(Model model, @PathVariable Integer id){
        model.addAttribute("nutritionist", this.userService.findByIdNutritionist(id));
        model.addAttribute("recipeList",this.userService.findRecipeByNutritionist(id));
        if (Auth.getUser().getId()==null){
            return "redirect:/users/login";
        }
        return "profile";
    }

    @GetMapping("/clients/{id}")
    public String findByIdClient(Model model, @PathVariable Integer id){
        model.addAttribute("client", this.userService.findByIdClient(id));
        if (Auth.getUser().getId()==null){
            return "redirect:/users/login";
        }
        return "profile";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/add")
    public String insert(Model model){
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("")
    public String save(User user){
        //user.setId(userService.findAllUser().size());
        System.out.println(user);
        userService.insert(user);
        return "redirect:/users/nutritionists/"+ Auth.getUser().getId();
    }

    /*
    Funcionalidad no implementada

    @GetMapping("")
    public String findAllMNutritionist(Model model){
        model.addAttribute("nutritionistList",this.userService.findAllNutritionist());
        return "nutritionistList";
    }


    */
}
