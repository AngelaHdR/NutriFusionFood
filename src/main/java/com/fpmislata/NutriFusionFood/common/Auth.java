package com.fpmislata.NutriFusionFood.common;

import com.fpmislata.NutriFusionFood.domain.entity.User;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class Auth {
    public static User currentUser = new User(3,"Pepe","Escudero","Ramirez","1985-10-24", true,"password3","mail3","pepe");
    //public static User currentUser = new User();
    public static User getUser(){
        //User currentUser = LocaleContextHolder.getLocale();
        return currentUser;
    }
    public static void setUser(User user){
        currentUser=user;
    }
}

