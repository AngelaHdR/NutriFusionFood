package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.persistance.dao.IngredientDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.Rawsql;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.IngredientEntityMapper;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.ToolEntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredientDaoJdbc implements IngredientDao {
    private IngredientEntity ingredientEntity;
    private List<IngredientEntity> ingredientEntityList;

    @Override
    public List<IngredientEntity> findAllIngredient() {
        try {
            ingredientEntityList = new ArrayList<>();
            String sql = "SELECT * from ingredient";
            ResultSet resultSet = Rawsql.select(sql, null);
            while (resultSet.next()) {
                ingredientEntityList.add(IngredientEntityMapper.toIngredientEntity(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return ingredientEntityList;

    }


    @Override
    public IngredientEntity findByIdIngredient(Integer id) {
        try {
            String sql = "SELECT * from ingredient where id_ingredient=?";
            List<Object> params = List.of(id);
            ResultSet resultSet = Rawsql.select(sql, params);
            resultSet.next();
            ingredientEntity = IngredientEntityMapper.toIngredientEntity(resultSet);
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }

        return ingredientEntity;
    }


    @Override
    public void insert(IngredientEntity ingredientEntity) {
    String sql = "INSERT INTO ingredient(id_ingredient, gluten, lactose, name_es, name_en, start_season, end_season, id_type) VALUES(?,?,?,?,?,?,?,?)";
    List<Object> params = List.of(ingredientEntity.getId(), ingredientEntity.isGluten(), ingredientEntity.isLactose(),
            ingredientEntity.getName_es(), ingredientEntity.getName_en(), ingredientEntity.getStartSeason(),
            ingredientEntity.getEndSeason(), ingredientEntity.getTypeId());
    Rawsql.insert(sql, params);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM ingredient WHERE id_ingredient=?";
        List<Object> params = List.of(id);
        Rawsql.delete(sql, params);
    }

    @Override
    public List<IngredientEntity> findByRecipe(Integer recipeId) {
        try {
            String sql = "SELECT i.id_ingredient, i.gluten, i.lactose, i.name_es, i.name_en, i.start_season, i.end_season, i.id_type " +
                    "FROM ingredient i inner join composed c on i.id_ingredient= c.id_ingredient where c.id_recipe= ?;";
            List<Object> params = List.of(recipeId);
            ResultSet resultSet = Rawsql.select(sql, params);
            ingredientEntityList = new ArrayList<>();
            while (resultSet.next()) {
                ingredientEntityList.add(IngredientEntityMapper.toIngredientEntity(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return ingredientEntityList;
    }
}
