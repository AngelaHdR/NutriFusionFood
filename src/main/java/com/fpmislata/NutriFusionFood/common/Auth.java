package com.fpmislata.NutriFusionFood.common;

import com.fpmislata.NutriFusionFood.domain.entity.User;

public class Auth {
    public static User current_user;
    public static User getUser(){
        return current_user;
    }
    public static void setUser(User user){
        current_user=user;
    }
}
