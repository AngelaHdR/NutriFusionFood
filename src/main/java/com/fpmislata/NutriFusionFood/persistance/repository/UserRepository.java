package com.fpmislata.NutriFusionFood.persistance.repository;

import com.fpmislata.NutriFusionFood.domain.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAllUser();
    /*public User findByIdNutritionist(Integer id);
    public User findByIdClient(Integer id);*/
    public User findByIdUser(Integer id);
    public void insert(User user);
    public List<User> findAllNutritionist();
    public User findByEmail(String email,String password);
    public User findByUsername(String username, String password);
}
