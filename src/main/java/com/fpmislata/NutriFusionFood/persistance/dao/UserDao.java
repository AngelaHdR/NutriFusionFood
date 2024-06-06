package com.fpmislata.NutriFusionFood.persistance.dao;

import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;

import java.util.List;

public interface UserDao {
    public List<UserEntity> findAllUser();
    /*public UserEntity findByIdNutritionist(Integer id);
    public UserEntity findByIdClient(Integer id);*/
    public void insert(UserEntity userEntity);
    public List<UserEntity> findAllNutritionist();
    public UserEntity findByEmail(String email,String password);
    public UserEntity findByUsername(String username, String password);
    public UserEntity findByIdUser(Integer id);
}
