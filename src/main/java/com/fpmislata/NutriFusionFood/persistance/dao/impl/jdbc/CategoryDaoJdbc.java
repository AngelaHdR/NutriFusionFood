package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.CategoryDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.Rawsql;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.CategoryEntityMapper;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoJdbc implements CategoryDao {
    private List<CategoryEntity> categoryEntityList;
    private CategoryEntity categoryEntity;
    private String lang = AppPropertiesReader.getInstance().getProperty("lang");

    @Override
    public List<CategoryEntity> findAllCategory() {
        try {
            categoryEntityList = new ArrayList<>();
            String sql = "SELECT id_category,name_"+lang+" as name FROM category";
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
    public CategoryEntity findByIdCategory(Integer id) {
        try {
            String sql = "SELECT id_category,name_"+lang+" as name FROM category WHERE id_category = ?";
            List<Object> params = List.of(id);
            ResultSet resultSet = Rawsql.select(sql, params);
            resultSet.next();
            categoryEntity = CategoryEntityMapper.toCategoryEntity(resultSet);
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return categoryEntity;
    }
}
