package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.common.LangUtil;
import com.fpmislata.NutriFusionFood.persistance.dao.IngredientDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.Rawsql;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.IngredientEntityMapper;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.ToolEntityMapper;
import org.springframework.context.i18n.LocaleContextHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class IngredientDaoJdbc implements IngredientDao {
    private IngredientEntity ingredientEntity;
    private List<IngredientEntity> ingredientEntityList;

    @Override
    public List<IngredientEntity> findAllIngredient() {
        try {
            ingredientEntityList = new ArrayList<>();
            String sql = "SELECT i.*,t.id_type,t.name_"+ LangUtil.getLang()+" as name from ingredient i inner join type t on i.id_type=t.id_type";
            ResultSet resultSet = Rawsql.select(sql, null);
            while (resultSet.next()) {
                ingredientEntityList.add(IngredientEntityMapper.toIngredientEntity(resultSet,LangUtil.getLang()));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return ingredientEntityList;

    }


    @Override
    public IngredientEntity findByIdIngredient(Integer id) {
        try {
            String sql = "SELECT i.*,t.id_type,t.name_"+LangUtil.getLang()+" as name from ingredient i inner join type t on i.id_type=t.id_type where id_ingredient=?";
            List<Object> params = List.of(id);
            ResultSet resultSet = Rawsql.select(sql, params);
            if(!resultSet.next()) {
                return null;
            }
            ingredientEntity = IngredientEntityMapper.toIngredientEntity(resultSet,LangUtil.getLang());
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return ingredientEntity;
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
            //buscar el idioma de la receta
            String sql = "SELECT lang FROM recipe WHERE id_recipe = ?";
            List<Object> params = List.of(recipeId);
            ResultSet resultSet = Rawsql.select(sql, params);
            if(!resultSet.next()) {
                return null;
            }
            String lang2 = resultSet.getString("lang");
            //mostrar la receta en su idioma
            String sql2 = "SELECT i.*,t.id_type,t.name_"+lang2+" as name FROM type t inner join ingredient i on t.id_type=i.id_type " +
                    "inner join composed c on i.id_ingredient = c.id_ingredient WHERE c.id_recipe= ?";
            List<Object> params2 = List.of(recipeId);
            ResultSet resultSet2 = Rawsql.select(sql2, params2);
            ingredientEntityList = new ArrayList<>();
            while (resultSet2.next()) {
                ingredientEntityList.add(IngredientEntityMapper.toIngredientEntity(resultSet2,lang2));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return ingredientEntityList;
    }

    @Override
    public List<IngredientEntity> findByType(int typeId){
        try {
            String sql = "SELECT i.*,t.id_type,t.name_"+LangUtil.getLang()+" as name FROM type t inner join ingredient i on t.id_type=i.id_type " +
                    " WHERE t.id_type = ?";
            List<Object> params = List.of(typeId);
            ResultSet resultSet = Rawsql.select(sql, params);
            ingredientEntityList = new ArrayList<>();
            while (resultSet.next()) {
                ingredientEntityList.add(IngredientEntityMapper.toIngredientEntity(resultSet,LangUtil.getLang()));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return ingredientEntityList;
    }
}

