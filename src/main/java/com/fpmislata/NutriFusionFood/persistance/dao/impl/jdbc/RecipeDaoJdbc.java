package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.common.LangUtil;
import com.fpmislata.NutriFusionFood.common.container.IngredientIoC;
import com.fpmislata.NutriFusionFood.common.container.ToolIoC;
import com.fpmislata.NutriFusionFood.persistance.dao.IngredientDao;
import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.ToolDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.StepEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.Rawsql;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.RecipeEntityMapper;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.StepsMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDaoJdbc implements RecipeDao {
    private List<RecipeEntity> recipeEntityList;
    private RecipeEntity recipeEntity;

    private RecipeEntity completesteps(RecipeEntity recipeEntity){
        String sql1 = "SELECT s.* FROM steps s WHERE s.id_recipe = ?";
        List<Object> params1 = List.of(recipeEntity.getId());
        ResultSet resultSet1 = Rawsql.select(sql1,params1);
        recipeEntity.setSteps(StepsMapper.toStepsList(resultSet1));
        return recipeEntity;
    }



    @Override
    public List<RecipeEntity> findAllRecipe() {
        try {
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+ LangUtil.getLang() +" as name FROM users u inner join recipe r on u.id_user=r.id_user " +
                    "inner join category c on r.id_category=c.id_category";
            ResultSet resultSet = Rawsql.select(sql, null);
            recipeEntityList = new ArrayList<>();
            while (resultSet.next()) {
                recipeEntityList.add(completesteps(RecipeEntityMapper.toRecipeEntity(resultSet)));
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
            recipeEntity = completesteps(RecipeEntityMapper.toRecipeEntity(resultSet));
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
        String sql = "INSERT INTO recipe (name_recipe, lang, description_recipe, time_recipe, id_user, id_category)" +
                " VALUES(?,?,?,?,?,?)";
        List<Object> params = List.of( recipeEntity.getName(), recipeEntity.getLanguage(), recipeEntity.getDescription(),
                recipeEntity.getTime(), recipeEntity.getUser().getId(), recipeEntity.getCategory().getId());
        Object recipeId = Rawsql.insert(sql, params);

        //insertar los pasos
        for (StepEntity step:recipeEntity.getSteps()){
            String sql3 = "INSERT INTO steps (id_recipe, id_step, description_step)" +
                    " VALUES(?,?,?)";
            List<Object> params3 = List.of(recipeId, step.getId(),step.getDescription());
            Rawsql.insert(sql3, params3);
        }

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

    //Verification for the insert, no duplicate recipes accepted in one profile
    @Override
    public RecipeEntity findByNameAndNutritionist(String name, int userId) {
        try {
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+LangUtil.getLang()+" as name FROM users u inner join recipe r on u.id_user=r.id_user " +
                    "inner join category c on r.id_category=c.id_category WHERE r.id_user = ? and name_recipe = ?";
            List<Object> params = List.of(userId,name);
            ResultSet resultSet = Rawsql.select(sql, params);
            if (!resultSet.next()){
                return null;
            }
            return RecipeEntityMapper.toRecipeEntity(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(RecipeEntity recipeEntity, List<IngredientEntity> ingredientEntityList, List<ToolEntity> toolEntityList) {
        IngredientDao ingredientDao = IngredientIoC.getIngredientDao();
        List<IngredientEntity> oldIngredientEntityList = ingredientDao.findByRecipe(recipeEntity.getId());
        ToolDao toolDao = ToolIoC.getToolDao();
        List<ToolEntity> oldToolEntityList = toolDao.findByRecipe(recipeEntity.getId());
        //actualizar la receta
        String sql = "UPDATE recipe SET name_recipe = ?, lang = ?, description_recipe = ?, time_recipe = ?, id_user = ?, id_category = ? WHERE id_recipe = ?";
        List<Object> params = List.of( recipeEntity.getName(), recipeEntity.getLanguage(), recipeEntity.getDescription(),
                recipeEntity.getTime(), recipeEntity.getUser().getId(), recipeEntity.getCategory().getId(), recipeEntity.getId());
        Rawsql.update(sql, params);

        //actualizar los pasos
        String sql1 = "DELETE FROM steps WHERE id_recipe = ?";
        List<Object> params1 = List.of(recipeEntity.getId());
        Rawsql.delete(sql1, params1);
        for (StepEntity step:recipeEntity.getSteps()){
            String sql3 = "INSERT INTO steps (id_recipe, id_step, description_step)" +
                    " VALUES(?,?,?)";
            List<Object> params3 = List.of(recipeEntity.getId(), step.getId(),step.getDescription());
            Rawsql.insert(sql3, params3);
        }

        //insertar los nuevos ingredientes en la tabla secundaria composed y borrar los antiguos
        for (IngredientEntity ingredient:ingredientEntityList){
            if (!oldIngredientEntityList.contains(ingredient)){
                String sql2 = "INSERT INTO composed (id_recipe, id_ingredient)" +
                        " VALUES(?,?)";
                List<Object> params2 = List.of(recipeEntity.getId(), ingredient.getId());
                Rawsql.insert(sql2, params2);
            }
        }
        for (IngredientEntity ingredient:oldIngredientEntityList){
            if (!ingredientEntityList.contains(ingredient)){
                String sql2 = "DELETE FROM composed WHERE id_recipe = ? and id_ingredient = ?";
                List<Object> params2 = List.of(recipeEntity.getId(), ingredient.getId());
                Rawsql.delete(sql2, params2);
            }
        }

        //insertar los nuevos utensilios en la tabla secundaria required y borrar los antiguos
        for (ToolEntity tool:toolEntityList){
            if (!oldToolEntityList.contains(tool)){
                String sql3 = "INSERT INTO required (id_recipe, id_tool)" +
                        " VALUES(?,?)";
                List<Object> params3 = List.of(recipeEntity.getId(), tool.getId());
                Rawsql.insert(sql3, params3);
            }
        }
        for (ToolEntity tool:oldToolEntityList){
            if (!toolEntityList.contains(tool)){
                String sql2 = "DELETE FROM required WHERE id_recipe = ? and id_tool = ?";
                List<Object> params2 = List.of(recipeEntity.getId(), tool.getId());
                Rawsql.delete(sql2, params2);
            }
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
                recipeEntityList.add(completesteps(RecipeEntityMapper.toRecipeEntity(resultSet)));
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
                recipeEntityList.add(completesteps(RecipeEntityMapper.toRecipeEntity(resultSet)));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return recipeEntityList;
    }

    @Override
    public List<RecipeEntity> findByTime(Integer timeMin,Integer timeMax) {
        try {
            String sql = "SELECT r.*,u.*,c.id_category,c.name_"+LangUtil.getLang()+" as name FROM users u inner join recipe r on u.id_user=r.id_user " +
                    "inner join category c on r.id_category=c.id_category WHERE r.time_recipe > ? and r.time_recipe < ?";
            List<Object> params = List.of(timeMin,timeMax);
            ResultSet resultSet = Rawsql.select(sql, params);
            recipeEntityList = new ArrayList<>();
            while (resultSet.next()) {
                recipeEntityList.add(completesteps(RecipeEntityMapper.toRecipeEntity(resultSet)));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return recipeEntityList;
    }



    //Favorite recipes for each user
    @Override
    public void addFavorites(RecipeEntity recipeEntity, Integer userId) {
        String sql = "INSERT INTO favorites (id_recipe, id_user) VALUES(?,?)";
        List<Object> params = List.of(recipeEntity.getId(), userId);
        Object favoriteId = Rawsql.insert(sql, params);
    }

    @Override
    public void removeFavorites(RecipeEntity recipeEntity, Integer userId) {
        String sql = "DELETE FROM favorites WHERE id_recipe = ? and id_user = ?";
        List<Object> params = List.of(recipeEntity.getId(), userId);
        Rawsql.delete(sql, params);
    }

    @Override
    public List<RecipeEntity> findFavoritesByUser(Integer userId) {
        try {
            String sql = "SELECT f.* FROM favorites f WHERE f.id_user = ?";
            List<Object> params = List.of(userId);
            ResultSet resultSet = Rawsql.select(sql, params);
            recipeEntityList = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println(findByIdRecipe(resultSet.getInt("id_recipe")));
                recipeEntityList.add(findByIdRecipe(resultSet.getInt("id_recipe")));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return recipeEntityList;
    }
}
