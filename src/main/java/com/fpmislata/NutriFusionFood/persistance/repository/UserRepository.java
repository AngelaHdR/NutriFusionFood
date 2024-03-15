package com.fpmislata.NutriFusionFood.persistance.repository;

import java.util.List;

public interface UserRepository {
    public List<User> findAllUser();
    public User findByIdUser(Integer id);
}
