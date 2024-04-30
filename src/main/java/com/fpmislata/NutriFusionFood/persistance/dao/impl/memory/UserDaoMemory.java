package com.fpmislata.NutriFusionFood.persistance.dao.impl.memory;

import com.fpmislata.NutriFusionFood.persistance.dao.UserDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDaoMemory implements UserDao {

    List<UserEntity> userEntityList = new ArrayList<>(Arrays.asList(
            new UserEntity(1,"Jose","Perez","Garcia","1989-08-18", true,"p1","mail1","jose"),
            new UserEntity(2,"Alicia","Fernandez","Lopez","2000-12-04", false,"p2","mail2","alicia"),
            new UserEntity(3,"Pepe","Escudero","Ramirez","1985-10-24", true,"p3","mail3","pepe"),
            new UserEntity(4,"Mercedes","Gil","Diaz","2000-04-14", false,"p4","mail4","mercedes")
    ));

    @Override
    public List<UserEntity> findAllUser() {
        return userEntityList;
    }

    @Override
    public UserEntity findByIdNutritionist(Integer id) {
        List<UserEntity> nutritionistList = findAllNutritionist();
        for (UserEntity userEntity:nutritionistList){
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
