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

    @GetMapping("/{id}")
    public String findByIdUser(Model model, @PathVariable Integer id){
        User user = userService.findByIdUser(id);
        if (Auth.getUser().getId()==null){
            return "redirect:/users/login/add";
        } else if (user.getNutritionist()) {
            return "redirect:/users/nutritionists/"+user.getId();
        } else if (!user.getNutritionist()) {
            return "redirect:/users/clients/"+user.getId();
        }else {
            return "error";
        }
    }

    @GetMapping("/nutritionists/{id}")
    public String findByIdNutritionist(Model model, @PathVariable Integer id){
        model.addAttribute("nutritionist", this.userService.findByIdUser(id));
        model.addAttribute("recipeList",this.userService.findRecipeByNutritionist(id));
        model.addAttribute("favorites",this.userService.findFavoritesByUser(id));
        //System.out.println(this.userService.findFavoritesByUser(id));
        if (Auth.getUser().getId()==null){
            return "redirect:/users/login/add";
        }
        return "users/profileNutritionist";
    }

    @GetMapping("/clients/{id}")
    public String findByIdClient(Model model, @PathVariable Integer id){
        model.addAttribute("favorites",this.userService.findFavoritesByUser(id));
        model.addAttribute("client", this.userService.findByIdUser(id));
        if (Auth.getUser().getId()==null){
            return "redirect:/users/login/add";
        }
        if (Auth.getUser().getId()!=id){
            return "error";
        }
        return "users/profileClient";
    }

    @GetMapping("/nutritionists")
    public String findAllMNutritionist(Model model){
        model.addAttribute("nutritionistList",this.userService.findAllNutritionist());
        return "users/nutritionistList";
    }

    @GetMapping("/login/add")
    public String login(Model model){
        Auth.setUser(new User());
        model.addAttribute("user", new User());
        return "Login";
    }
    @PostMapping("/login")
    public String enter(User user){
        Auth.setUser(userService.findByEmailOrUsername(user));
        if (Auth.getUser().getNutritionist()){
            return "redirect:/users/nutritionists/"+Auth.getUser().getId();
        } else if (!Auth.getUser().getNutritionist()) {
            return "redirect:/users/clients/"+Auth.getUser().getId();
        }else {
            return "error";
        }
    }

    @GetMapping("/add")
    public String insert(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("")
    public String save(User user) {
        userService.insert(user);
        return "redirect:/users/nutritionists/" + Auth.getUser().getId();
    }
    /*
    Funcionalidad no implementada




    */
}
