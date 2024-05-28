package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.TypeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.Rawsql;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.CategoryEntityMapper;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.TypeEntityMapper;
import org.springframework.context.i18n.LocaleContextHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TypeDaoJdbc implements TypeDao {
    private List<TypeEntity> typeEntityList;
    private TypeEntity typeEntity;
    private String lang;

    public TypeDaoJdbc() {
        Locale currentLocale = LocaleContextHolder.getLocale();
        this.lang = currentLocale.getLanguage();
    }

    @Override
    public List<TypeEntity> findAllType() {
        try {
            String sql = " SELECT id_type,name_"+lang+" FROM type";
            ResultSet resultSet = Rawsql.select(sql, null);
            typeEntityList = new ArrayList<>();
            while (resultSet.next()) {
                typeEntityList.add(TypeEntityMapper.toTypeEntity(resultSet,lang));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return typeEntityList;
    }

    @Override
    public TypeEntity findByIdType(Integer id) {
        try {
            String sql = " SELECT id_type,name_"+lang+" FROM type WHERE id_type = ?";
            List<Object> params = List.of(id);
            ResultSet resultSet = Rawsql.select(sql, params);
            if(!resultSet.next()) {
                return null;
            }
            typeEntity = TypeEntityMapper.toTypeEntity(resultSet,lang);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typeEntity;
    }
}
