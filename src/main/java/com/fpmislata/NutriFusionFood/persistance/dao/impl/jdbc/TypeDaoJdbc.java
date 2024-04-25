package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.persistance.dao.TypeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.Rawsql;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.CategoryEntityMapper;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.TypeEntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDaoJdbc implements TypeDao {
    private List<TypeEntity> typeEntityList;
    private TypeEntity typeEntity;

    @Override
    public List<TypeEntity> findAllType() {
        try {
            String sql = " SELECT * FROM type";
            ResultSet resultSet = Rawsql.select(sql, null);
            typeEntityList = new ArrayList<>();
            while (resultSet.next()) {
                typeEntityList.add(TypeEntityMapper.toTypeEntity(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return typeEntityList;
    }

    @Override
    public TypeEntity findByIdType(Integer id) {
        try {
            String sql = " SELECT * FROM type WHERE id_type = ?";
            List<Object> params = List.of(id);
            ResultSet resultSet = Rawsql.select(sql, params);
            resultSet.next();
            typeEntity = TypeEntityMapper.toTypeEntity(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typeEntity;
    }
}
