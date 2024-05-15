package com.fpmislata.NutriFusionFood.persistance.repository;

import com.fpmislata.NutriFusionFood.domain.entity.User;

import java.util.List;

public interface UserRepository {
    public User findByIdNutritionist(Integer id);
    public void insert(User user);
    public List<User> findAllNutritionist();
    public List<User> findAllUser();
    public User findByEmailOrUsername(String email, String username);
}
