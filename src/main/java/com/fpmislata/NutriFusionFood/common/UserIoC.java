package com.fpmislata.NutriFusionFood.common;

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
            userDao = new UserDaoImpl();
        }
        return userDao;
    }
}
