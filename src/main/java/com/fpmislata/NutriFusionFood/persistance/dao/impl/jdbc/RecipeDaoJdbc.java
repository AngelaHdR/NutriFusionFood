package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.Rawsql;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.RecipeEntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDaoJdbc implements RecipeDao {
    private List<RecipeEntity> recipeEntityList;
    private RecipeEntity recipeEntity;
    private String lang = AppPropertiesReader.getInstance().getProperty("lang");

    @Override
    public List<RecipeEntity> findAllRecipe() {
        try {
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+lang+" as name FROM user u inner join recipe r on u.id_user=r.id_user " +
                    "inner join category c on r.id_category=c.id_category WHERE r.lang=?";
            List<Object> params = List.of(lang);
            ResultSet resultSet = Rawsql.select(sql, params);
            recipeEntityList = new ArrayList<>();
            while (resultSet.next()) {
                recipeEntityList.add(RecipeEntityMapper.toRecipeEntity(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return recipeEntityList;
    }

    @Override
    public RecipeEntity findByIdRecipe(Integer id) {
        try {
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+lang+" as name FROM user u inner join recipe r on u.id_user=r.id_user " +
                    "inner join category c on r.id_category=c.id_category WHERE r.id_recipe = ? and r.lang=?";
            List<Object> params = List.of(id,lang);
            ResultSet resultSet = Rawsql.select(sql, params);
            resultSet.next();
            recipeEntity = RecipeEntityMapper.toRecipeEntity(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return recipeEntity;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM recipe WHERE id_recipe=?";
        List<Object> params = List.of(id);
        Rawsql.delete(sql, params);
    }

    @Override
    public void insert(RecipeEntity recipeEntity) {
        String sql = "INSERT INTO recipe (id_recipe, name_recipe, lang, description_recipe, steps, time_recipe, id_user, id_category)" +
                " VALUES(?,?,?,?,?,?,?,?)";
        List<Object> params = List.of(recipeEntity.getId(), recipeEntity.getName(), recipeEntity.getLanguage(), recipeEntity.getDescription(),
                recipeEntity.getSteps(), recipeEntity.getTime(), recipeEntity.getUser().getId(), recipeEntity.getCategory().getId());
        Rawsql.insert(sql, params);
    }

    @Override
    public List<RecipeEntity> findByCategory(Integer categoryId) {
        try {
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+lang+" as name FROM user u inner join recipe r on u.id_user=r.id_user " +
                    "inner join category c on r.id_category=c.id_category WHERE r.id_category = ? and r.lang=?";
            List<Object> params = List.of(categoryId,lang);
            ResultSet resultSet = Rawsql.select(sql, params);
            recipeEntityList = new ArrayList<>();
            while (resultSet.next()) {
                recipeEntityList.add(RecipeEntityMapper.toRecipeEntity(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return recipeEntityList;
    }

    @Override
    public List<RecipeEntity> findByNutritionist(Integer nutritionistId) {
        try {
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+lang+" as name FROM user u inner join recipe r on u.id_user=r.id_user " +
                    "inner join category c on r.id_category=c.id_category WHERE r.id_user = ? and r.lang=?";
            List<Object> params = List.of(nutritionistId,lang);
            ResultSet resultSet = Rawsql.select(sql, params);
            recipeEntityList = new ArrayList<>();
            while (resultSet.next()) {
                recipeEntityList.add(RecipeEntityMapper.toRecipeEntity(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return recipeEntityList;
    }

    @Override
    public RecipeEntity findByNameAndNutritionist(String name, int userId) {
        try {
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+lang+" as name FROM user u inner join recipe r on u.id_user=r.id_user " +
                    "inner join category c on r.id_category=c.id_category WHERE r.id_user = ? and r.name = ?";
            List<Object> params = List.of(name,userId);
            ResultSet resultSet = Rawsql.select(sql, params);
            resultSet.next();
            return RecipeEntityMapper.toRecipeEntity(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
