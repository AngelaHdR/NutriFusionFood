package com.fpmislata.NutriFusionFood.domain.service.impl;

import com.fpmislata.NutriFusionFood.common.Auth;
import com.fpmislata.NutriFusionFood.common.container.RecipeIoC;
import com.fpmislata.NutriFusionFood.common.exceptions.BusinessException;
import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.domain.service.UserService;
import com.fpmislata.NutriFusionFood.persistance.repository.RecipeRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    RecipeRepository recipeRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.recipeRepository = RecipeIoC.getRecipeRepository();
    }

    /*@Override
    public User findByIdNutritionist(Integer id) {
        User user = this.userRepository.findByIdNutritionist(id);
        if (user==null) {
            throw new BusinessException("There is no nutritionist with id: " + id);
        }
        return user;
    }

    @Override
    public User findByIdClient(Integer id) {
        User user = this.userRepository.findByIdClient(id);
        if (user==null) {
            throw new BusinessException("There is no client with id: " + id);
        }
        return user;
    }*/

    @Override
    public User findByIdUser(Integer id) {
        User user = this.userRepository.findByIdUser(id);
        if (user==null) {
            throw new BusinessException("There is no user with id: " + id);
        }
        return user;
    }

    @Override
    public void insert(User user) {
        if (user.getPassword().length()<8){
            throw new BusinessException("The password has to contain minimum 8 characters");
        }
        if (user.getNutritionist()==null){
            user.setNutritionist(false);
        }
        User userExists1 = this.userRepository.findByEmail(user.getEmail(), user.getPassword());
        User userExists2 = this.userRepository.findByUsername(user.getUsername(), user.getPassword());

        if (userExists1!=null || userExists2!=null){
            throw new BusinessException("This email or username is already in use");
        }else{
            user.setId(userRepository.findAllUser().size()+1);
            userRepository.insert(user);
            Auth.setUser(user);
        }

    }

    @Override
    public List<User> findAllNutritionist() {
        List<User> userList = this.userRepository.findAllNutritionist();
        if (userList.isEmpty()){
            throw new BusinessException("There are no nutritionists in the database");
        }
        return userList;
    }
    @Override
    public List<User> findAllUser() {
        List<User> userList = this.userRepository.findAllUser();
        if (userList.isEmpty()){
            throw new BusinessException("There are no users in the database");
        }
        return userList;
    }
    @Override
    public List<Recipe> findRecipeByNutritionist(Integer nutritionistId){
        return this.recipeRepository.findByNutritionist(nutritionistId);
    }

    @Override
    public User findByEmailOrUsername(User user) {
        if (user.getUsername()==null){
            return this.userRepository.findByEmail(user.getEmail(),user.getPassword());
        } else if (user.getEmail()==null) {
            return this.userRepository.findByUsername(user.getUsername(),user.getPassword());
        }
        return null;
    }

}
