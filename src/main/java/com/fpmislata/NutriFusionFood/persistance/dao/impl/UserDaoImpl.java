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
            new UserEntity(2,"Alicia","Fernandez","Lopez",new Date("2000-12-04"), false),
            new UserEntity(3,"Pepe","Escudero","Ramirez",new Date("1985-10-24"), true),
            new UserEntity(4,"Mercedes","Gil","Diaz",new Date("2000-04-14"), false)
    ));
    @Override
    public List<UserEntity> findAllUser() {
        return userEntityList;
    }

    @Override
    public UserEntity findByIdUser(Integer id) {
        for (UserEntity userEntity:userEntityList){
            if (userEntity.getId().equals(id)){
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
