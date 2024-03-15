package com.fpmislata.NutriFusionFood.persistance.dao;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;

import java.util.List;

public interface UserDao {
    public List<UserEntity> findAllUser();
    public UserEntity findByIdUser(Integer id);
}
