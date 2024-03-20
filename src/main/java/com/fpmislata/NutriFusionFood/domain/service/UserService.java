package com.fpmislata.NutriFusionFood.domain.service;

import com.fpmislata.NutriFusionFood.domain.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAllUser();
    public User findByIdUser(Integer id);
    public void delete(Integer id);
    public void insert(User user);
    public List<User> findAllNutritionist();
}
