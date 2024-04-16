package com.fpmislata.NutriFusionFood.persistance.repository.mapper;

import com.fpmislata.NutriFusionFood.domain.entity.User;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static User toUser(UserEntity userEntity){
        return new User(userEntity.getId(),userEntity.getName(),userEntity.getSurname1(), userEntity.getSurname2(), userEntity.getBirthDate(),userEntity.isNutritionist(),userEntity.getPassword());
    }
    public static UserEntity toUserEntity(User user){
        return new UserEntity(user.getId(), user.getName(), user.getSurname1(), user.getSurname2(), user.getBirthDate(),user.isNutritionist(),user.getPassword());
    }
    public static List<User> toUserList(List<UserEntity> userEntityList){
        List<User> userList = new ArrayList<>();
        for (UserEntity userEntity:userEntityList){
            userList.add(toUser(userEntity));
        }
        return userList;
    }
    
}
