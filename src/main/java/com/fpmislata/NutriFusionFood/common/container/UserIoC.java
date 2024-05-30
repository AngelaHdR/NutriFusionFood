package com.fpmislata.NutriFusionFood.common.container;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.domain.service.UserService;
import com.fpmislata.NutriFusionFood.domain.service.impl.UserServiceImpl;
import com.fpmislata.NutriFusionFood.persistance.dao.UserDao;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.UserDaoJdbc;
import com.fpmislata.NutriFusionFood.persistance.repository.UserRepository;
import com.fpmislata.NutriFusionFood.persistance.repository.impl.UserRepositoryImpl;

public class UserIoC {
    private static UserService userService;
    private static UserRepository userRepository;
    private static UserDao userDao;
    public static UserService getUserService(){
        if (userService==null){
            userService = new UserServiceImpl(getUserRepository());
        }
        return userService;
    }
    public static UserRepository getUserRepository(){
        if (userRepository==null){
            userRepository = new UserRepositoryImpl(getUserDao());
        }
        return userRepository;
    }
    public static UserDao getUserDao(){
        if (userDao==null){
            if (AppPropertiesReader.getInstance().getProperty("daoimpl").equals("jdbc")){
                userDao = new UserDaoJdbc();
            }
        }
        return userDao;
    }
    public static void setUserService(UserService userService) {
        UserIoC.userService = userService;
    }
    public static void setUserRepository(UserRepository userRepository) {
        UserIoC.userRepository = userRepository;
    }
    public static void setUserDao(UserDao userDao) {
        UserIoC.userDao = userDao;
    }
    public static void reset() {
        userService = null;
        userRepository = null;
        userDao = null;
    }
}
