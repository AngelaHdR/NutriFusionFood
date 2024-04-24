package unit.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.RequireDao;
import com.fpmislata.NutriFusionFood.persistance.dao.ToolDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.RequireDaoMemory;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.ToolDaoMemory;

public class ToolDaoUnitTest {
    ToolDao toolDao = new ToolDaoMemory();
    RequireDao requireDao = new RequireDaoMemory();

    @DisplayName("Find all the tools in the database")
    @Test
    public void testFindAllTools() {
        List<ToolEntity> actualToolList = toolDao.findAllTool();
        List<ToolEntity> expectedToolList = new ArrayList<>(Arrays.asList(
            new ToolEntity(1,"cuchara","spoon"),
            new ToolEntity(2,"bol","bowl"),
            new ToolEntity(3,"sarten","frying pan"),
            new ToolEntity(4,"olla","pot"),
            new ToolEntity(5,"vaso medidor","measuring cup"),
            new ToolEntity(6,"batidora","blender")
        ));
        assertEquals(expectedToolList, actualToolList);
    }

    @DisplayName("Find tools by their id")
    @Test
    public void testFindToolById() {
        ToolEntity actualTool = toolDao.findByIdTool(1);
        ToolEntity expectedTool = new ToolEntity(1,"cuchara","spoon");
        assertEquals(expectedTool, actualTool);
    }

    @DisplayName("Find tools by their recipes")
    @Test
    public void testFindToolByRecipe() {
        List<ToolEntity> actualToolList = toolDao.findByRecipe(1);
        List<ToolEntity> expectedToolList = new ArrayList<>(Arrays.asList(new ToolEntity(3,"sarten","frying pan")));
        assertEquals(expectedToolList, actualToolList);
    }

    @DisplayName("Insert new tools in the database")
    @Test
    public void testInsertNewTools() {
        toolDao.insert(new ToolEntity(7, "freidora", "fryer"));
        List<ToolEntity> actualToolList = toolDao.findAllTool();
        List<ToolEntity> expectedToolList = new ArrayList<>(Arrays.asList(
            new ToolEntity(1,"cuchara","spoon"),
            new ToolEntity(2,"bol","bowl"),
            new ToolEntity(3,"sarten","frying pan"),
            new ToolEntity(4,"olla","pot"),
            new ToolEntity(5,"vaso medidor","measuring cup"),
            new ToolEntity(6,"batidora","blender"),
            new ToolEntity(7, "freidora", "fryer")
        ));
        assertEquals(expectedToolList, actualToolList);
    }

    @DisplayName("Delete tools from the database")
    @Test
    public void testDeleteTools() {
        toolDao.delete(6);
        List<ToolEntity> actualToolList = toolDao.findAllTool();
        List<ToolEntity> expectedToolList = new ArrayList<>(Arrays.asList(
            new ToolEntity(1,"cuchara","spoon"),
            new ToolEntity(2,"bol","bowl"),
            new ToolEntity(3,"sarten","frying pan"),
            new ToolEntity(4,"olla","pot"),
            new ToolEntity(5,"vaso medidor","measuring cup")
        ));
        assertEquals(expectedToolList, actualToolList);
    }
}
