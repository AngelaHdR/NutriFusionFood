package unit.persistance.dao.impl.jdbc;

import com.fpmislata.NutriFusionFood.persistance.dao.RecipeDao;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.CategoryEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.RecipeEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.entity.UserEntity;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.RecipeDaoJdbc;
import com.fpmislata.NutriFusionFood.persistance.dao.impl.jdbc.db.DBConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static data.RecipeData.findRecipeEntityList;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RecipeDaoJdbcTest {
    private static final RecipeDao recipeDao = new RecipeDaoJdbc();
    private static final DBConnection connection = DBConnection.getInstance();
    public static List<Arguments> availableLanguages(){
        return List.of(arguments("es"),arguments("en"));
    }
    @BeforeAll
    static void setup() throws SQLException {
        connection.executeScript("schemaNFFtest.sql");
        connection.executeScript("dataNFFtest.sql");
        connection.getConnection().setAutoCommit(false);
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.getConnection().rollback();
    }
    @DisplayName("Find all the recipes in the database")
    @ParameterizedTest
    @MethodSource("availableLanguages")
    public void testFindAllRecipes(String lang) {
        List<RecipeEntity> actualRecipeList = recipeDao.findAllRecipe();
        List<RecipeEntity> expectedRecipeList = findRecipeEntityList();
        assertEquals(expectedRecipeList, actualRecipeList);
    }

    @DisplayName("Find recipes by their id")
    @ParameterizedTest
    @MethodSource("availableLanguages")
    public void testFindRecipeById(String lang) {
        RecipeEntity actualRecipe = recipeDao.findByIdRecipe(1);
        RecipeEntity expectedRecipe = findRecipeEntityList().get(0);
        assertEquals(expectedRecipe, actualRecipe);
    }

    @ParameterizedTest
    @ValueSource(ints={0,-3,30})
    @DisplayName("Return null if recipe id not in list")
    public void returnNullWrongRecipeId(int id){
        RecipeEntity actualRecipe = recipeDao.findByIdRecipe(id);
        assertNull(actualRecipe);
    }

    @DisplayName("Find recipes by their recipes")
    @ParameterizedTest
    @MethodSource("availableLanguages")
    public void testFindRecipeByNutritionist(String lang) {
        List<RecipeEntity> actualRecipeList = recipeDao.findByNutritionist(1);
        List<RecipeEntity> expectedRecipeList = new ArrayList<>(Arrays.asList(findRecipeEntityList().get(2)));
        assertEquals(expectedRecipeList, actualRecipeList);
    }
    @ParameterizedTest
    @ValueSource(ints={0,-3,30})
    @DisplayName("Return void list if recipe id not in list")
    public void returnVoidWrongRecipeId(int id){
        List<RecipeEntity> actualRecipeList = recipeDao.findByCategory(id);
        List<RecipeEntity> expected = new ArrayList<>();
        assertEquals(expected,actualRecipeList);
    }

    @DisplayName("Insert new recipes in the database")
    @ParameterizedTest
    @MethodSource("availableLanguages")
    public void testInsertNewRecipes(String lang) {
        RecipeEntity newRecipe= new RecipeEntity(6,"Ensalada", "es","x","Paso 1...", 15,
                new UserEntity(3,"Pepe","Escudero","Ramirez","1985-10-24", true,"password3","mail3","pepe"),
                new CategoryEntity(3,"bebida"));
        List<RecipeEntity> expectedRecipeList = new ArrayList<>(findRecipeEntityList());
        recipeDao.insert(newRecipe,new ArrayList<>(),new ArrayList<>());
        List<RecipeEntity> actualRecipeList = recipeDao.findAllRecipe();
        assertEquals(expectedRecipeList, actualRecipeList);
    }

    @DisplayName("Delete recipes from the database")
    @ParameterizedTest
    @MethodSource("availableLanguages")
    public void testDeleteRecipes(String lang) {
        recipeDao.delete(6);
        List<RecipeEntity> actualRecipeList = recipeDao.findAllRecipe();
        List<RecipeEntity> expectedRecipeList = new ArrayList<>(findRecipeEntityList());
        expectedRecipeList.remove(5);
        assertEquals(expectedRecipeList, actualRecipeList);
    }

}