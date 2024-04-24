package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.persistance.dao.CategoryDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.Rawsql;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.CategoryEntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoJdbc implements CategoryDao {
    private List<CategoryEntity> categoryEntityList;
    private  CategoryEntity categoryEntity;

    @Override
    public List<CategoryEntity> findAllCategory() {
        try {
            categoryEntityList = new ArrayList<>();
            String sql = "SELECT * FROM category";
            ResultSet resultSet = Rawsql.select(sql, null);
            while (resultSet.next()) {

                categoryEntityList.add(CategoryEntityMapper.toCategoryEntity(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }

        return categoryEntityList;
    }

    @Override
    public CategoryEntity findByIdCategory(Integer id){
       String sql = "SELECT * FROM category WHERE id_category = ?";
        List<Object> params = List.of(id);
        ResultSet resultSet = Rawsql.select(sql, params);
        try {
            resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        categoryEntity = CategoryEntityMapper.toCategoryEntity(resultSet);
        return categoryEntity;
    }
}
