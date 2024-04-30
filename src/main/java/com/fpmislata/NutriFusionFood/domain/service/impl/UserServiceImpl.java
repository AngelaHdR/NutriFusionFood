package com.fpmislata.NutriFusionFood.domain.service.impl;

import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.domain.service.UserService;
import com.fpmislata.NutriFusionFood.persistance.repository.UserRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.UserMapper;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByIdNutritionist(Integer id) {
        return this.userRepository.findByIdNutritionist(id);
    }

    @Override
    public void insert(User user) {
        userRepository.insert(user);
    }

    @Override
    public List<User> findAllNutritionist() {
        return this.userRepository.findAllNutritionist();
    }
    @Override
    public List<User> findAllUser() {
        return this.userRepository.findAllUser();
    }

}
