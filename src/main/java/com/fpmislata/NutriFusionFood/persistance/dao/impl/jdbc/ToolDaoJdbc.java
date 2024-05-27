package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.persistance.dao.ToolDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.Rawsql;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.ToolEntityMapper;
import org.springframework.context.i18n.LocaleContextHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ToolDaoJdbc implements ToolDao {
    private List<ToolEntity> toolEntityList;
    private ToolEntity toolEntity;
    private String lang;

    public ToolDaoJdbc() {
        Locale currentLocale = LocaleContextHolder.getLocale();
        this.lang = currentLocale.getLanguage();
    }

    @Override
    public List<ToolEntity> findAllTool() {
        try {
            String sql = "SELECT t.id_tool,t.name_"+lang+" as name FROM tool t";
            ResultSet resultSet = Rawsql.select(sql, null);
            toolEntityList = new ArrayList<>();
            while (resultSet.next()) {
                toolEntityList.add(ToolEntityMapper.toToolEntity(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return toolEntityList;
    }

    @Override
    public ToolEntity findByIdTool(Integer id) {
        try {
            String sql = "SELECT t.id_tool,t.name_"+lang+" as name FROM tool t WHERE id_tool = ?";
            List<Object> params = List.of(id);
            ResultSet resultSet = Rawsql.select(sql, params);
            if(!resultSet.next()) {
                return null;
            }
            toolEntity = ToolEntityMapper.toToolEntity(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toolEntity;
    }

    @Override
    public List<ToolEntity> findByRecipe(Integer recipeId) {
        try {
            //buscar el idioma de la receta
            String sql = "SELECT lang FROM recipe WHERE id_recipe = ?";
            List<Object> params = List.of(recipeId);
            ResultSet resultSet = Rawsql.select(sql, params);
            resultSet.next();
            String lang2 = resultSet.getString("lang");
            //mostrar la receta en su idioma
            String sql2 = "SELECT t.id_tool,t.name_"+lang2+" as name FROM tool t " +
                    "inner join required r on t.id_tool= r.id_tool where r.id_recipe = ?";
            List<Object> params2 = List.of(recipeId);
            ResultSet resultSet2 = Rawsql.select(sql2, params2);
            toolEntityList = new ArrayList<>();
            while (resultSet2.next()) {
                toolEntityList.add(ToolEntityMapper.toToolEntity(resultSet2));
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return toolEntityList;
    }

    @Override
    public void insert(ToolEntity toolEntity) {
        String sql = "INSERT INTO tool(id_tool,name_"+lang+") VALUES(?,?,?)";
        List<Object> params = List.of(toolEntity.getId(), toolEntity.getName());
        Rawsql.insert(sql, params);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM tool WHERE id_tool=?";
        List<Object> params = List.of(id);
        Rawsql.delete(sql, params);
    }
}
