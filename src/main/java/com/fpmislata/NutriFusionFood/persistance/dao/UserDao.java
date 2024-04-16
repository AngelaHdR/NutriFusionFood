package com.fpmislata.NutriFusionFood.persistance.dao;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;

import java.util.List;

public interface UserDao {
    public UserEntity findByIdNutritionist(Integer id);
    public void insert(UserEntity userEntity);
    public List<UserEntity> findAllNutritionist();
}
