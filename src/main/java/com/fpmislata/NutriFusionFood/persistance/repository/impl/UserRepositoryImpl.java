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
    public User findByIdNutritionist(Integer id) {
        return UserMapper.toUser(userDao.findByIdNutritionist(id));
    }

    @Override
    public User findByIdClient(Integer id) {
        return UserMapper.toUser(userDao.findByIdClient(id));
    }

    @Override
    public User findByIdUser(Integer id) {
        return UserMapper.toUser(userDao.findByIdUser(id));
    }

    @Override
    public void insert(User user) {
        userDao.insert(UserMapper.toUserEntity(user));
    }

    @Override
    public List<User> findAllNutritionist() {
        return UserMapper.toUserList(userDao.findAllNutritionist());
    }

    @Override
    public List<User> findAllUser() {
        return UserMapper.toUserList(userDao.findAllUser());
    }

    @Override
    public User findByEmail(String email, String password) {
        return UserMapper.toUser(userDao.findByEmail(email, password));
    }
    @Override
    public User findByUsername(String username, String password) {
        return UserMapper.toUser(userDao.findByUsername(username,password));
    }
}
