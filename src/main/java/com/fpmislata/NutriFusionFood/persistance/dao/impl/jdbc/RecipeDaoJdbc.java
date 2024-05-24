package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.Rawsql;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.RecipeEntityMapper;
import org.springframework.context.i18n.LocaleContextHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RecipeDaoJdbc implements RecipeDao {
    private List<RecipeEntity> recipeEntityList;
    private RecipeEntity recipeEntity;
    private String lang;

    public RecipeDaoJdbc() {
        Locale currentLocale = LocaleContextHolder.getLocale();
        this.lang = currentLocale.getLanguage();
    }

    @Override
    public List<RecipeEntity> findAllRecipe() {
        try {
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+lang+" as name FROM users u inner join recipe r on u.id_user=r.id_user " +
                    "inner join category c on r.id_category=c.id_category";
            ResultSet resultSet = Rawsql.select(sql, null);
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
            String sql2 = "SELECT r.*,u.*,c.id_category,c.name_"+lang+" as name FROM users u inner join recipe r on u.id_user=r.id_user " +
                    "inner join category c on r.id_category=c.id_category WHERE r.id_recipe = ?";
            List<Object> params2 = List.of(id);
            ResultSet resultSet2 = Rawsql.select(sql2, params2);
            resultSet2.next();
            recipeEntity = RecipeEntityMapper.toRecipeEntity(resultSet2);
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
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+lang+" as name FROM users u inner join recipe r on u.id_user=r.id_user " +
                    "inner join category c on r.id_category=c.id_category WHERE r.id_category = ?";
            List<Object> params = List.of(categoryId);
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
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+lang+" as name FROM users u inner join recipe r on u.id_user=r.id_user " +
                    "inner join category c on r.id_category=c.id_category WHERE r.id_user = ?";
            List<Object> params = List.of(nutritionistId);
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
            //buscar el idioma de la receta
            String sql = "SELECT lang FROM recipe WHERE id_user = ? and name = ?";
            List<Object> params = List.of(userId,name);
            ResultSet resultSet = Rawsql.select(sql, params);
            resultSet.next();
            lang = resultSet.getString("lang");
            //mostrar la receta en su idioma
            String sql2 = "SELECT r.*,u.*,c.id_category,c.name_"+lang+" as name FROM users u inner join recipe r on u.id_user=r.id_user " +
                    "inner join category c on r.id_category=c.id_category WHERE r.id_user = ? and r.name = ?";
            List<Object> params2 = List.of(name,userId);
            ResultSet resultSet2 = Rawsql.select(sql2, params2);
            resultSet2.next();
            return RecipeEntityMapper.toRecipeEntity(resultSet2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
