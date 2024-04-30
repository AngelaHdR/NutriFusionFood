package com.fpmislata.NutriFusionFood.domain.service;

import com.fpmislata.NutriFusionFood.domain.entity.User;

import java.util.List;

public interface UserService {
    public User findByIdNutritionist(Integer id);
    public void insert(User user);
    public List<User> findAllNutritionist();
    public List<User> findAllUser();
}
