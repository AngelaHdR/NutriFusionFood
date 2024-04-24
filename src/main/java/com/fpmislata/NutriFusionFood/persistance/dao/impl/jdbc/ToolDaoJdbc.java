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
        try{
            String sql = "SELECT * FROM tool";
            ResultSet resultSet = Rawsql.select(sql,null);
            toolEntityList = new ArrayList<>();
            while (resultSet.next()){
                resultSet.next();
                toolEntityList.add(ToolEntityMapper.toToolEntity(resultSet));
            }
        }catch (SQLException e){
            System.out.println("Hay un problema con la bbdd");
        }
        return toolEntityList;
    }

    @Override
    public ToolEntity findByIdTool(Integer id) {
        String sql = "SELECT * FROM tool WHERE id_tool = ?";
        List<Object> params = List.of(id);
        ResultSet resultSet = Rawsql.select(sql,params);
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
        return null;
    }

    @Override
    public void insert(ToolEntity toolEntity) {

    }

    @Override
    public void delete(Integer id) {

    }
}
