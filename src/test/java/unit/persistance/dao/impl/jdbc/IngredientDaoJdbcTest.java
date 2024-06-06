package unit.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.persistance.dao.IngredientDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.IngredientEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.TypeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.IngredientDaoJdbc;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.DBConnection;
import static data.IngredientData.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.JdbcTest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class IngredientDaoJdbcTest extends JdbcTest {
    private static final IngredientDao ingredientDao = new IngredientDaoJdbc();

    private static final DBConnection connection = DBConnection.getInstance();


    IngredientEntity ingredientEntity;
    public static List<Arguments> availableLanguages(){
        return List.of(arguments("es"),arguments("en"));
    }

    @DisplayName("Find all the ingredients in the database")
    @ParameterizedTest
    @MethodSource("availableLanguages")
    public void testFindAllIngredients(String lang) {
        List<IngredientEntity> actualIngredientList = ingredientDao.findAllIngredient();
        List<IngredientEntity> expectedIngredientList = findIngredientEntityList(lang);
        assertEquals(expectedIngredientList, actualIngredientList);
    }

    @DisplayName("Find ingredients by their ids")
    @ParameterizedTest
    @MethodSource("availableLanguages")
    public void testFindIngredientsById(String lang) {
        IngredientEntity actualIngredient = ingredientDao.findByIdIngredient(1);
        IngredientEntity expectedIngredient = findIngredientEntityList(lang).get(0);
        assertEquals(expectedIngredient, actualIngredient);
    }
    @ParameterizedTest
    @ValueSource(ints={0,-3,30})
    @DisplayName("Return null for negative,zero or wrong id")
    public void returnNullWrongIngredientId(int id){
        IngredientEntity ingredientEntity = ingredientDao.findByIdIngredient(id);
        assertNull(ingredientEntity);
    }

    @DisplayName("Find the ingredients by their recipes")
    @ParameterizedTest
    @MethodSource("availableLanguages")
    public void testFindIngredientsByRecipe(String lang) {
        List<IngredientEntity> actualIngredientList = ingredientDao.findByRecipe(2);
        List<IngredientEntity> expectedIngredientList = new ArrayList<>(Arrays.asList(findIngredientEntityList(lang).get(2)));
        assertEquals(expectedIngredientList, actualIngredientList);
    }
    @ParameterizedTest
    @ValueSource(ints={0,-3,30})
    @DisplayName("Return null for negative,zero or wrong id")
    public void returnNullWrongRecipeId(int id){
        List<IngredientEntity> actualIngredientList = ingredientDao.findByRecipe(id);
        assertNull(actualIngredientList);
    }

    @DisplayName("Delete ingredients from the database")
    @ParameterizedTest
    @MethodSource("availableLanguages")
    public void testDeleteIngredients(String lang) {
        ingredientDao.delete(5);
        List<IngredientEntity> actualIngredientList = ingredientDao.findAllIngredient();
        List<IngredientEntity> expectedIngredientList = new ArrayList<>(findIngredientEntityList(lang));
        expectedIngredientList.remove(4);
        assertEquals(expectedIngredientList, actualIngredientList);
    }
}