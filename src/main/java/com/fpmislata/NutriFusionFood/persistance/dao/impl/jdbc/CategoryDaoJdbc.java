package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.persistance.dao.CategoryDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.Rawsql;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.CategoryEntityMapper;
import org.springframework.context.i18n.LocaleContextHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CategoryDaoJdbc implements CategoryDao {
    private List<CategoryEntity> categoryEntityList;
    private CategoryEntity categoryEntity;

    private final String lang;

    public CategoryDaoJdbc() {
        Locale currentLocale = LocaleContextHolder.getLocale();
        this.lang = currentLocale.getLanguage();
    }


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
            if(!resultSet.next()) {
                return null;
            }
            categoryEntity = CategoryEntityMapper.toCategoryEntity(resultSet);
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return categoryEntity;
    }
}
