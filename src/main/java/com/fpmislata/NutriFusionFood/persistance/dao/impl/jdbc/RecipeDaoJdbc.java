package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.common.LangUtil;
import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.Rawsql;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.RecipeEntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDaoJdbc implements RecipeDao {
    private List<RecipeEntity> recipeEntityList;
    private RecipeEntity recipeEntity;


    @Override
    public List<RecipeEntity> findAllRecipe() {
        try {
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+ LangUtil.getLang() +" as name FROM users u inner join recipe r on u.id_user=r.id_user " +
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
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+ LangUtil.getLang() +" as name FROM users u inner join recipe r on u.id_user=r.id_user " +
                    "inner join category c on r.id_category=c.id_category WHERE r.id_recipe = ?";
            List<Object> params = List.of(id);
            ResultSet resultSet = Rawsql.select(sql, params);
            if(!resultSet.next()) {
                return null;
            }
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
    public void insert(RecipeEntity recipeEntity, List<IngredientEntity> ingredientEntityList, List<ToolEntity> toolEntityList) {
        //insertar la receta
        String sql = "INSERT INTO recipe (name_recipe, lang, description_recipe, steps, time_recipe, id_user, id_category)" +
                " VALUES(?,?,?,?,?,?,?)";
        List<Object> params = List.of( recipeEntity.getName(), recipeEntity.getLanguage(), recipeEntity.getDescription(),
                recipeEntity.getSteps(), recipeEntity.getTime(), recipeEntity.getUser().getId(), recipeEntity.getCategory().getId());
        Object recipeId = Rawsql.insert(sql, params);

        //insertar los ingredientes en la tabla secundaria composed
        for (IngredientEntity ingredient:ingredientEntityList){
            String sql2 = "INSERT INTO composed (id_recipe, id_ingredient)" +
                    " VALUES(?,?)";
            List<Object> params2 = List.of(recipeId, ingredient.getId());
            Rawsql.insert(sql2, params2);
        }

        //insertar los utensilios en la tabla secundaria required
        for (ToolEntity tool:toolEntityList){
            String sql3 = "INSERT INTO required (id_recipe, id_tool)" +
                    " VALUES(?,?)";
            List<Object> params3 = List.of(recipeId, tool.getId());
            Rawsql.insert(sql3, params3);
        }
    }

    @Override
    public void update(RecipeEntity recipeEntity, List<IngredientEntity> ingredientEntityList, List<ToolEntity> toolEntityList) {
        //actualizar la receta
        String sql = "UPDATE recipe SET name_recipe = ?, lang = ?, description_recipe = ?, steps = ?, time_recipe = ?, id_user = ?, id_category = ? WHERE id_recipe = ?";
        List<Object> params = List.of( recipeEntity.getName(), recipeEntity.getLanguage(), recipeEntity.getDescription(),
                recipeEntity.getSteps(), recipeEntity.getTime(), recipeEntity.getUser().getId(), recipeEntity.getCategory().getId(), recipeEntity.getId());
        Object recipeId = Rawsql.update(sql, params);

        //insertar los ingredientes en la tabla secundaria composed
        for (IngredientEntity ingredient:ingredientEntityList){
            String sql2 = "INSERT INTO composed (id_recipe, id_ingredient)" +
                    " VALUES(?,?)";
            List<Object> params2 = List.of(recipeId, ingredient.getId());
            Rawsql.insert(sql2, params2);
        }

        //insertar los utensilios en la tabla secundaria required
        for (ToolEntity tool:toolEntityList){
            String sql3 = "INSERT INTO required (id_recipe, id_tool)" +
                    " VALUES(?,?)";
            List<Object> params3 = List.of(recipeId, tool.getId());
            Rawsql.insert(sql3, params3);
        }
    }

    @Override
    public List<RecipeEntity> findByCategory(Integer categoryId) {
        try {
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+LangUtil.getLang()+" as name FROM users u inner join recipe r on u.id_user=r.id_user " +
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
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+LangUtil.getLang()+" as name FROM users u inner join recipe r on u.id_user=r.id_user " +
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
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+LangUtil.getLang()+" as name FROM users u inner join recipe r on u.id_user=r.id_user " +
                    "inner join category c on r.id_category=c.id_category WHERE r.id_user = ? and name_recipe = ?";
            List<Object> params = List.of(userId,name);
            ResultSet resultSet = Rawsql.select(sql, params);
            if (!resultSet.next()){
                return null;
            }
            //mostrar la receta en su idioma
            return RecipeEntityMapper.toRecipeEntity(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
