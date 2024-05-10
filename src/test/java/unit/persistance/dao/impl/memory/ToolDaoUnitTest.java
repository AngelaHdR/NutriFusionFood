package unit.persistance.dao.impl.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fpmislata.NutriFusionFood.common.AppPropertiesReader;
import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import antiguo.memory.RecipeDaoMemory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fpmislata.NutriFusionFood.persistance.dao.ToolDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.ToolEntity;
import antiguo.memory.ToolDaoMemory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ToolDaoUnitTest {
    ToolDao toolDao = new ToolDaoMemory();

    private String lang = AppPropertiesReader.getInstance().getProperty("lang");

    @DisplayName("Find all the tools in the database")
    @Test
    public void testFindAllTools() {
        List<ToolEntity> actualToolList = toolDao.findAllTool();
        List<ToolEntity> expectedToolList;
        if (lang.equals("es")) {
            expectedToolList = new ArrayList<>(Arrays.asList(
                    new ToolEntity(1, "cuchara"),
                    new ToolEntity(2, "bol"),
                    new ToolEntity(3, "sarten"),
                    new ToolEntity(4, "olla"),
                    new ToolEntity(5, "vaso medidor"),
                    new ToolEntity(6, "batidora")
            ));
        }else if (lang.equals("en")) {
            expectedToolList = new ArrayList<>(Arrays.asList(
                    new ToolEntity(1, "cuchara"),
                    new ToolEntity(2, "bol"),
                    new ToolEntity(3, "sarten"),
                    new ToolEntity(4, "olla"),
                    new ToolEntity(5, "vaso medidor"),
                    new ToolEntity(6, "batidora")
            ));
        }else {
            expectedToolList=new ArrayList<>();
        }
        assertEquals(expectedToolList, actualToolList);
    }

    @DisplayName("Find tools by their id")
    @Test
    public void testFindToolById() {
        ToolEntity actualTool = toolDao.findByIdTool(1);
        String name;
        if (lang.equals("es")) {
            name = "cuchara";
        }else if (lang.equals("en")) {
            name = "spoon";
        }else{
            name = null;
        }
        ToolEntity expectedTool=new ToolEntity(1, name);
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
    @Test
    public void testFindToolByRecipe() {
        List<ToolEntity> actualToolList = toolDao.findByRecipe(1);
        List<ToolEntity> expectedToolList;
        if (lang.equals("es")){
            expectedToolList= new ArrayList<>(Arrays.asList(new ToolEntity(3,"sarten")));
        } else if (lang.equals("en")) {
            expectedToolList= new ArrayList<>(Arrays.asList(new ToolEntity(3,"pan")));
        }else{
            expectedToolList= new ArrayList<>();
        }
        assertEquals(expectedToolList, actualToolList);
    }
    @ParameterizedTest
    @ValueSource(ints={0,-3,30})
    @DisplayName("Return void list if recipe id not in list")
    public void returnNullWrongRecipeId(int id){
        List<ToolEntity> actualToolList = toolDao.findByRecipe(id);
        List<ToolEntity> expected = new ArrayList<>();
        assertEquals(expected,actualToolList);
    }

    @DisplayName("Insert new tools in the database")
    @Test
    public void testInsertNewTools() {
        toolDao.insert(new ToolEntity(7, "freidora"));
        List<ToolEntity> actualToolList = toolDao.findAllTool();
        List<ToolEntity> expectedToolList = new ArrayList<>(Arrays.asList(
            new ToolEntity(1,"cuchara"),
            new ToolEntity(2,"bol"),
            new ToolEntity(3,"sarten"),
            new ToolEntity(4,"olla"),
            new ToolEntity(5,"vaso medidor"),
            new ToolEntity(6,"batidora"),
            new ToolEntity(7, "freidora")
        ));
        assertEquals(expectedToolList, actualToolList);
    }

    @DisplayName("Delete tools from the database")
    @Test
    public void testDeleteTools() {
        toolDao.delete(6);
        List<ToolEntity> actualToolList = toolDao.findAllTool();
        List<ToolEntity> expectedToolList = new ArrayList<>(Arrays.asList(
            new ToolEntity(1,"cuchara"),
            new ToolEntity(2,"bol"),
            new ToolEntity(3,"sarten"),
            new ToolEntity(4,"olla"),
            new ToolEntity(5,"vaso medidor")
        ));
        assertEquals(expectedToolList, actualToolList);
    }
}
