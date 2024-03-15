package com.fpmislata.NutriFusionFood.domain.service;

import com.fpmislata.NutriFusionFood.domain.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAllUser();
    public User findByIdUser(Integer id);
}
