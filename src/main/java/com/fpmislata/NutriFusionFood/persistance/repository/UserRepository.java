package com.fpmislata.NutriFusionFood.persistance.repository;

import com.fpmislata.NutriFusionFood.domain.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAllUser();
    public User findByIdUser(Integer id);
}
