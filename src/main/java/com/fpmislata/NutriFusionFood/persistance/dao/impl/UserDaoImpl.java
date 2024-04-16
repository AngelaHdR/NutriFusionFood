package com.fpmislata.NutriFusionFood.persistance.dao.impl;

import com.fpmislata.NutriFusionFood.persistance.dao.UserDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDaoImpl implements UserDao {

    List<UserEntity> userEntityList = new ArrayList<>(Arrays.asList(
            new UserEntity(1,"Jose","Perez","Garcia","1989-08-18", true,"p1"),
            new UserEntity(2,"Alicia","Fernandez","Lopez","2000-12-04", false,"p2"),
            new UserEntity(3,"Pepe","Escudero","Ramirez","1985-10-24", true,"p3"),
            new UserEntity(4,"Mercedes","Gil","Diaz","2000-04-14", false,"p4")
    ));

    @Override
    public UserEntity findByIdNutritionist(Integer id) {
        for (UserEntity userEntity:userEntityList){
            if (userEntity.getId().equals(id)){
                return userEntity;
            }
        }
        return null;
    }

    @Override
    public void insert(UserEntity userEntity) {
        userEntityList.add(userEntity);
    }

    @Override
    public List<UserEntity> findAllNutritionist() {
        List<UserEntity> nutritionistList = new ArrayList<>();
        for (UserEntity userEntity:userEntityList){
            if (userEntity.isNutritionist()){
                nutritionistList.add(userEntity);
            }
        }
        return nutritionistList;
    }

}
