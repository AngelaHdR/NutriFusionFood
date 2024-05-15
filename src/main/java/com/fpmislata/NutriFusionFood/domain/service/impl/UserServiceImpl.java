package com.fpmislata.NutriFusionFood.domain.service.impl;

import com.fpmislata.NutriFusionFood.common.container.RecipeIoC;
import com.fpmislata.NutriFusionFood.common.exceptions.ServiceException;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.domain.service.UserService;
import com.fpmislata.NutriFusionFood.persistance.repository.RecipeRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.UserRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.UserMapper;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    RecipeRepository recipeRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.recipeRepository = RecipeIoC.getRecipeRepository();
    }

    @Override
    public User findByIdNutritionist(Integer id) {
        User user = this.userRepository.findByIdNutritionist(id);
        if (user==null) {
            throw new ServiceException("There is no nutritionist with id: " + id);
        } else if (!user.isNutritionist()) {
            throw new ServiceException("The user with this id is not a nutritionist");
        }
        return user;
    }

    @Override
    public void insert(User user) {
        List<User> userList = this.userRepository.findAllUser();
        for (User user1:userList) {
            if (user.getEmail().equals(user1.getEmail())){
                throw new ServiceException("This email is already in use");
            } else if (user.getUsername().equals(user1.getUsername())) {
                throw new ServiceException("This username is already in use");
            }
        }
        if (user.getPassword().length()<8){
            throw new ServiceException("The password has to contain minimum 8 characters");
        }
        userRepository.insert(user);
    }

    @Override
    public List<User> findAllNutritionist() {
        List<User> userList = this.userRepository.findAllNutritionist();
        if (userList.isEmpty()){
            throw new ServiceException("There are no nutritionists in the database");
        }
        return userList;
    }
    @Override
    public List<User> findAllUser() {
        List<User> userList = this.userRepository.findAllUser();
        if (userList.isEmpty()){
            throw new ServiceException("There are no users in the database");
        }
        return userList;
    }
    @Override
    public List<Recipe> findRecipeByNutritionist(Integer nutritionistId){
        return this.recipeRepository.findByNutritionist(nutritionistId);
    };

}
