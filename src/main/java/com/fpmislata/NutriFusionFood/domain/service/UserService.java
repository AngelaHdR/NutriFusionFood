package com.fpmislata.NutriFusionFood.domain.service;

import com.fpmislata.NutriFusionFood.domain.entity.Recipe;
import com.fpmislata.NutriFusionFood.domain.entity.User;

import java.util.List;

public interface UserService {
    /*public User findByIdNutritionist(Integer id);
    public User findByIdClient(Integer id);*/
    public User findByIdUser(Integer id);
    public void insert(User user);
    public List<User> findAllNutritionist();
    public List<User> findAllUser();
    public List<Recipe> findRecipeByNutritionist(Integer nutritionistId);
    public List<Recipe> findFavoritesByUser(Integer userId);
    public User findByEmailOrUsername(User user);
}
