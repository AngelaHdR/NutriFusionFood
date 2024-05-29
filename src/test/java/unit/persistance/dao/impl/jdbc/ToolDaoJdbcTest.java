package unit.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.ToolDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.ToolDaoJdbc;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.DBConnection;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.memory.ToolDaoMemory;
import static data.ToolData.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.JdbcTest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ToolDaoJdbcTest extends JdbcTest {
    private static final ToolDao toolDao = new ToolDaoJdbc();

    @DisplayName("Find all the tools in the database")
    @ParameterizedTest
    @MethodSource("availableLanguages")
    public void testFindAllTools(String lang) {
        List<ToolEntity> actualToolList = toolDao.findAllTool();
        List<ToolEntity> expectedToolList = findToolEntityList(lang);
        assertEquals(expectedToolList, actualToolList);
    }

    @DisplayName("Find tools by their id")
    @ParameterizedTest
    @MethodSource("availableLanguages")
    public void testFindToolById(String lang) {
        ToolEntity actualTool = toolDao.findByIdTool(1);
        ToolEntity expectedTool = findToolEntityList(lang).get(0);
        assertEquals(expectedTool, actualTool);
    }

    @ParameterizedTest
    @ValueSource(ints={0,-3,30})
    @DisplayName("Return null if tool id not in list")
    public void returnNullWrongToolId(int id){
        ToolEntity actualTool = toolDao.findByIdTool(id);
        assertNull(actualTool);
    }
    @DisplayName("Find tools by their recipes")
    @ParameterizedTest
    @MethodSource("availableLanguages")
    public void testFindToolByRecipe(String lang) {
        List<ToolEntity> actualToolList = toolDao.findByRecipe(1);
        List<ToolEntity> expectedToolList = new ArrayList<>(Arrays.asList(findToolEntityList(lang).get(2)));
        assertEquals(expectedToolList, actualToolList);
    }
    @ParameterizedTest
    @ValueSource(ints={0,-3,30})
    @DisplayName("Return null if recipe id not in list")
    public void returnNullWrongRecipeId(int id){
        List<ToolEntity> actualToolList = toolDao.findByRecipe(id);
        assertNull(actualToolList);
    }

    @DisplayName("Delete tools from the database")
    @ParameterizedTest
    @MethodSource("availableLanguages")
    public void testDeleteTools(String lang) {
        toolDao.delete(6);
        List<ToolEntity> actualToolList = toolDao.findAllTool();
        List<ToolEntity> expectedToolList = new ArrayList<>(findToolEntityList(lang));
        expectedToolList.remove(5);
        assertEquals(expectedToolList, actualToolList);
    }

}