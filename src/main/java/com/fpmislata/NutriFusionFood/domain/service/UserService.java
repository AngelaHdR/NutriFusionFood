package com.fpmislata.NutriFusionFood.domain.service;

import java.util.List;

public interface UserService {
    public List<User> findAllUser();
    public User findByIdUser(Integer id);
}
