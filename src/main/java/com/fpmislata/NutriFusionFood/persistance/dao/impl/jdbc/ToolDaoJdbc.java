package com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.persistance.dao.ToolDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.Rawsql;
import com.fpmislata.NutriFusionFood.persistance.dao.mapper.ToolEntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToolDaoJdbc implements ToolDao {
    private List<ToolEntity> toolEntityList;
    private ToolEntity toolEntity;

    @Override
    public List<ToolEntity> findAllTool() {
        try {
            String sql = "SELECT * FROM tool";
            ResultSet resultSet = Rawsql.select(sql, null);
            toolEntityList = new ArrayList<>();
            resultSet.next();
            while (resultSet.next()) {
                toolEntityList.add(ToolEntityMapper.toToolEntity(resultSet));
                resultSet.next();
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return toolEntityList;
    }

    @Override
    public ToolEntity findByIdTool(Integer id) {
        String sql = "SELECT * FROM tool WHERE id_tool = ?";
        List<Object> params = List.of(id);
        ResultSet resultSet = Rawsql.select(sql, params);
        try {
            resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        toolEntity = ToolEntityMapper.toToolEntity(resultSet);
        return toolEntity;
    }

    @Override
    public List<ToolEntity> findByRecipe(Integer recipeId) {
        try {
            String sql = "SELECT t.id_tool,t.name_es,t.name_en FROM tool t " +
                    "inner join required r on t.id_tool= r.id_tool where r.id_recipe = ?";
            List<Object> params = List.of(recipeId);
            ResultSet resultSet = Rawsql.select(sql, params);
            toolEntityList = new ArrayList<>();
            resultSet.next();
            while (resultSet.next()) {
                toolEntityList.add(ToolEntityMapper.toToolEntity(resultSet));
                resultSet.next();
            }
        } catch (SQLException e) {
            System.out.println("Hay un problema con la bbdd");
        }
        return toolEntityList;
    }

    @Override
    public void insert(ToolEntity toolEntity) {
        String sql = "INSERT INTO tool(id_tool, name_es, name_en) VALUES(?,?,?)";
        List<Object> params = List.of(toolEntity.getId(), toolEntity.getName_es(), toolEntity.getName_en());
        Rawsql.insert(sql, params);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM tool WHERE id_tool=?";
        List<Object> params = List.of(id);
        Rawsql.delete(sql, params);
    }
}
