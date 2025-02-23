package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.persistance.dao.UserDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.Rawsql;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.UserEntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbc implements UserDao {

    private List<UserEntity> userEntityList;

    private UserEntity userEntity;
    @Override
    public List<UserEntity> findAllUser() {
        try {
            userEntityList = new ArrayList<>();
            String sql = "SELECT * FROM users";
            ResultSet resultSet = Rawsql.select(sql,null);
            while (resultSet.next()) {
                userEntityList.add(UserEntityMapper.toUserEntity(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }

        return userEntityList;
    }
    @Override
    public UserEntity findByIdUser(Integer id) {
        try {
            String sql = "select * from users where id_user = ?";
            List<Object> params = List.of(id);
            ResultSet resultSet = Rawsql.select(sql, params);
            if(!resultSet.next()) {
                return null;
            }
            userEntity = UserEntityMapper.toUserEntity(resultSet);
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return userEntity;
    }

    /*@Override
    public UserEntity findByIdNutritionist(Integer id) {
        try {
            String sql = "select * from users where id_user = ? and nutritionist = ?";
            List<Object> params = List.of(id,1);
            ResultSet resultSet = Rawsql.select(sql, params);
            if(!resultSet.next()) {
                return null;
            }
            userEntity = UserEntityMapper.toUserEntity(resultSet);
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return userEntity;
    }

    @Override
    public UserEntity findByIdClient(Integer id) {
        try {
            String sql = "select * from users where id_user = ? and nutritionist = ?";
            List<Object> params = List.of(id,0);
            ResultSet resultSet = Rawsql.select(sql, params);
            if(!resultSet.next()) {
                return null;
            }
            userEntity = UserEntityMapper.toUserEntity(resultSet);
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return userEntity;
    }*/
    @Override
    public void insert(UserEntity userEntity) {
        String sql = "insert into users (name_user, surname1, surname2, username, email, birth_date, nutritionist, pwd)" +
                " values(?,?,?,?,?,?,?,?)";
        List<Object> params = List.of(userEntity.getName(), userEntity.getSurname1(),
                userEntity.getSurname2(), userEntity.getUsername(), userEntity.getEmail(),
                userEntity.getBirthDate(), userEntity.isNutritionist(), userEntity.getPassword());
        Rawsql.insert(sql, params);
    }

    @Override
    public List<UserEntity> findAllNutritionist() {
        try {
            userEntityList = new ArrayList<>();
            String sql = "select * from users where nutritionist = ?";
            List<Object> params = List.of(1);
            ResultSet resultSet = Rawsql.select(sql, params);
            while (resultSet.next()){
                userEntityList.add(UserEntityMapper.toUserEntity(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return userEntityList;
    }

    @Override
    public UserEntity findByEmail(String email,String password) {
        try {
            String sql = "select * from users where email =? and pwd = ?";
            List<Object> params = List.of(email,password);
            ResultSet resultSet = Rawsql.select(sql, params);
            if(!resultSet.next()) {
                return null;
            }
            return UserEntityMapper.toUserEntity(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public UserEntity findByUsername(String email, String password) {
        try {
            String sql = "select * from users where email =? or pwd = ?";
            List<Object> params = List.of(email,password);
            ResultSet resultSet = Rawsql.select(sql, params);
            if(!resultSet.next()) {
                return null;
            }
            return UserEntityMapper.toUserEntity(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
