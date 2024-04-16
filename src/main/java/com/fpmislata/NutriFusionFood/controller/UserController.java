package com.fpmislata.NutriFusionFood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fpmislata.NutriFusionFood.domain.entity.User;

import com.fpmislata.NutriFusionFood.common.UserIoC;
import com.fpmislata.NutriFusionFood.domain.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    UserService userService;
    public UserController(){
        this.userService = UserIoC.getUserService();
    }
    @GetMapping("")
    public String findAllMNutritionist(Model model){
        model.addAttribute("nutritionistList",this.userService.findAllNutritionist());
        return "nutritionistList";
    }
    @GetMapping("/{id}")
    public String findByIdNutritionist(Model model, @PathVariable Integer id){
        model.addAttribute("nutritionist", this.userService.findByIdNutritionist(id));
        return "profile";
    }
    @GetMapping("/add")
    public String insert(Model model){
        model.addAttribute("user", new User());
        return "userForm";
    }
    @PostMapping("")
    public String save(User user){
        userService.insert(user);
        return "redirect:/users";
    }
}
