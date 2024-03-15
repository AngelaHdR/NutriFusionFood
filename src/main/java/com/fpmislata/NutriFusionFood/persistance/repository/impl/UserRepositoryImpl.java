package com.fpmislata.NutriFusionFood.persistance.repository.impl;

import com.fpmislata.NutriFusionFood.domain.entity.User;

import com.fpmislata.NutriFusionFood.persistance.dao.UserDao;

import com.fpmislata.NutriFusionFood.persistance.repository.UserRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.mapper.UserMapper;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private UserDao userDao;

    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAllUser() {
        return UserMapper.toUserList(userDao.findAllUser());
    }

    @Override
    public User findByIdUser(Integer id) {
        return UserMapper.toUser(userDao.findByIdUser(id));
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public void insert(User user) {
        userDao.insert(UserMapper.toUserEntity(user));
    }

    @Override
    public List<User> findAllNutritionist() {
        return UserMapper.toUserList(userDao.findAllNutritionist());
    }
}
