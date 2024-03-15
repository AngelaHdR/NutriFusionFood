package com.fpmislata.NutriFusionFood.persistance.dao.impl;

import com.fpmislata.NutriFusionFood.persistance.dao.UserDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {

    List<UserEntity> userEntityList = new ArrayList<>(Arrays.asList(
            new UserEntity(1,"Jose","Perez","Garcia",new Date("1989-08-18"), true),
            new UserEntity(1,"Alicia","Fernandez","Lopez",new Date("2000-12-04"), false)
    ));
    @Override
    public List<UserEntity> findAllUser() {
        return userEntityList;
    }

    @Override
    public UserEntity findByIdUser(Integer id) {
        for (UserEntity userEntity:userEntityList){
            if (userEntity.getId()==id){
                return userEntity;
            }
        }
        return null;
    }
    @Override
    public void delete(Integer id) {
        userEntityList.remove(findByIdUser(id));
    }

    @Override
    public void insert(UserEntity userEntity) {
        userEntityList.add(userEntity);
    }

    @Override
    public List<UserEntity> findAllNutritionist() {
        List<UserEntity> nutritionistList = new ArrayList<>();
        for (UserEntity userEntity:userEntityList){
            if (userEntity.getNutritionist()){
                nutritionistList.add(userEntity);
            }
        }
        return nutritionistList;
    }

}
